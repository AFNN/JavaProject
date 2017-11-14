/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpdf;

/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */


 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestPDF {

    public static final String chemin = "C:/Users/fouil/Desktop/pdf/pdftest8.pdf";
    public static void main(String[] args)
  {
    Document document = new Document();
    String nom="Claude";
    String prenom="AUGUSTE";
    String motif ="Motif à définir";
    String dateheure = "Date à définir à (Heure à définir)";
    
            
    
    try 
    {
      PdfWriter.getInstance(document, new FileOutputStream(chemin));
      document.open();
      Paragraph paragraph= new Paragraph("Lycée Emile Zoulo \n4 rue des lilas \n75013 Paris");
      paragraph.setAlignment(Element.ALIGN_LEFT);
      document.add(paragraph);
      
      Paragraph paragraph1= new Paragraph("Convocation");
      paragraph1.setAlignment(Element.ALIGN_CENTER);
      document.add(paragraph1);
      
       
    
      
          
      document.add(new Paragraph("Madame, Monsieur "));
      document.add(new Paragraph("Vous êtes convoquée pour votre enfant : "+nom+" "+prenom+" dans le bureau de MR BERNARD Jean-Michel au lycée Emile Zoulo ."));
      document.add(new Paragraph("Motif: "+motif));
      document.add(new Paragraph("Date : "+dateheure));
      document.add(new Paragraph("Merci de confirmer votre présence au numéro suivant : 0237465434\n\n"));
      document.add(new Paragraph("Cordialement,\nLe directeur"));


    } catch (DocumentException de) {
      de.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
   
    document.close();
  }
  


 
    
}
        
        
        
        

