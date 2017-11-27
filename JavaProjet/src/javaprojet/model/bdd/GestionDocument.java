/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.model.bdd;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javaprojet.model.donnee.Etudiant;

/**
 *
 * @author Arnaud Fouillard 
 */
public class GestionDocument {


    /**
     * Permet de générer un document PDF. Ici une convocation pour les parents.
     * @param E 
     * @param motif
     * @param date
     * @param chemin
     */
    public static void GestionDocument(Etudiant E, String motif, Date date,String chemin){
        String Prenometu="",Nometu="",NomRes="",PrenomRes="",AdresseRes="";

        ResultSet resEtudiant=null;
        ResultSet resResponsable=null;
        Statement stmt=null;
        try {
            javaprojet.model.bdd.DBconnexion.connexionDB();
            stmt= DBconnexion.getConn().createStatement();
            String userinfo="SELECT * From etudiant WHERE Matricule="+E.getMatricule()+"";
            System.out.println(userinfo);
            String Responsableinfo="SELECT * FROM `responsable` WHERE Matricule="+E.getMatricule()+"";
            
            resEtudiant=stmt.executeQuery(userinfo);
            resEtudiant.first();
            Prenometu=resEtudiant.getString("NOM");
            Nometu=resEtudiant.getString("PRENOM");
          
            resResponsable=stmt.executeQuery(Responsableinfo);
            resResponsable.first();
            NomRes=resResponsable.getString("NomRes");
            PrenomRes=resResponsable.getString("PrenomRes");
            AdresseRes=resResponsable.getString("AdresseRes");
      
        } catch (SQLException SQLe) {
            System.out.println("Probleme lors de la recherche dans la BDD "+SQLe.getMessage());
                        
        }
       
        Document document = new Document();
        String dateheure = "Date à définir à (Heure à définir)";

        try {
            PdfWriter.getInstance(document, new FileOutputStream(chemin));
            document.open();
            Paragraph paragraph= new Paragraph("Lycée Emile Zoulo \n4 rue des lilas \n75013 Paris");
            paragraph.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph);
            Paragraph paragraphparent= new Paragraph("Monsieur "+NomRes+" "+PrenomRes+"\n"+AdresseRes+"\n");
            paragraphparent.setAlignment(Element.ALIGN_RIGHT);
            document.add(paragraphparent);
      
            Paragraph paragraph1= new Paragraph("Convocation");
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph1);

            document.add(new Paragraph("Madame, Monsieur "));
            document.add(new Paragraph("Vous êtes convoquée pour votre enfant : "+Nometu+" "+Prenometu+" dans le bureau de MR BERNARD Jean-Michel au lycée Emile Zoulo ."));
            document.add(new Paragraph("Motif: "+motif));
            document.add(new Paragraph("Date : "+date));
            document.add(new Paragraph("Merci de confirmer votre présence au numéro suivant : 0237465434\n\n"));
            document.add(new Paragraph("Cordialement,\nLe directeur"));

        } catch (DocumentException | IOException de) {
            de.printStackTrace();
        }
        System.out.println("javaprojet.model.bdd.GestionDocument.GestionDocument()");
        document.close();
    }
    public static void main(String[] args){
        Etudiant E= new Etudiant(1, "Fouillard", "Arnaud", 1);
        GestionDocument(E,"punition",Date.valueOf("2017-05-05"),"./DocumentPDF/Convocation_"+E.getNom()+"_"+E.getPrenom()+".pdf");   
    } 
}
    
  


 
    


