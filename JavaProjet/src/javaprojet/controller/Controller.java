/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.controller;

import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaprojet.model.bdd.DBconnexion;
import javaprojet.model.bdd.GestionCoordonnees;
import javaprojet.model.bdd.GestionDocument;
import javaprojet.model.bdd.GestionEtudiant;
import javaprojet.model.bdd.GestionIdentite;
import javaprojet.model.bdd.GestionResponsable;
import javaprojet.model.bdd.GestionSante;
import javaprojet.model.donnee.*;
import javaprojet.view.Accueil;
import javaprojet.view.Accueil_1;
import javaprojet.view.Accueil_2;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class Controller {
    BoutonListener blistener = new BoutonListener();
    Accueil Accueil = new Accueil();
    Accueil_1 Admin = new Accueil_1();
    Accueil_2 Aca = new Accueil_2();
    Etudiant etu = new Etudiant(0,"","",0);
    Etudiant etuDoc = new Etudiant(0, "", "", 0);
    Coordonnees c = new Coordonnees("", 0, "", "", "", "", 0);
    Identite i = new Identite("DateNaissance", "VilleNaissance", "PaysNaissance", "Sexe", "DateInscription", "Etablissementpr",0);
    Responsable r1 = new Responsable(0, "nom", "prenom", "adresse", "", "email", 0);
    Responsable r2= new Responsable(0, "nom", "prenom", "adresse", "", "email", 0);
    Sante s = new Sante(0, "medecinTraitant", "", "vaccinations", "allergies", "remarquesMedicales");
    
    /*
    public static boolean connect = false;
    public static boolean admin = false;
*/
  
   
    public Controller(){
        
        // Création d'évènement sur les bouttons de la page d'accueil
        Accueil.getjButtonAccueil().addActionListener(blistener);
        Accueil.getjButtonAdmin().addActionListener(blistener);
        Accueil.getjButtonAca().addActionListener(blistener);
        Accueil.getjButtonConnect().addActionListener(blistener);
        Accueil.getjButtonDiscon().addActionListener(blistener);
        
        // Création d'évènement sur les bouttons de la page Administration
        Admin.getjButtonAccueil().addActionListener(blistener);
        Admin.getjButtonAdmin().addActionListener(blistener);
        Admin.getjButtonAca().addActionListener(blistener);
        Admin.getjButtonokClasse().addActionListener(blistener);
        Admin.getjButtonchoixETU().addActionListener(blistener);
        Admin.getjButtonModifyCoord().addActionListener(blistener);
        Admin.getjButtonModifyGeneral().addActionListener(blistener);
        Admin.getjButtonModifyIdent().addActionListener(blistener);
        Admin.getjButtonModifyMed().addActionListener(blistener);
        Admin.getjButtonModifyR1().addActionListener(blistener);
        Admin.getjButtonModifyR2().addActionListener(blistener);
        Admin.getjButtonDocEdit().addActionListener(blistener);
        Admin.getjButtonDocImpr().addActionListener(blistener);
        
        // Création d'évènement sur les bouttons de la page Académique
        Aca.getjButtonAccueil().addActionListener(blistener);
        Aca.getjButtonAdmin().addActionListener(blistener);
        Aca.getjButtonAca().addActionListener(blistener);
        Aca.getjButtonChoixMatiere().addActionListener(blistener);
        Aca.getjButtonOkMatiere().addActionListener(blistener);
        Aca.getjButtonReChoixClasse().addActionListener(blistener);
        Aca.getjButtonReChoixEtu().addActionListener(blistener);
     
        
        //Initialisation de la page d'accueil en visible
        Accueil.setVisible(true);
        
        //Demande de confirmation pour quitter sur les 3 pages
        Accueil.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Accueil.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(Accueil, 
                "Voulez-vous vraiment quitter le programme ?", "Quitter le programme", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        Admin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Admin.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(Admin, 
                "Voulez-vous vraiment quitter le programme ?", "Quitter le programme", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        
        Aca.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Aca.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(Aca, 
                "Voulez-vous vraiment quitter le programme ?", "Quitter le programme", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

	//this.Connection=Connection;
	//Connection.getjButtonConnect().addActionListener(new BoutonListenerConnect());
		
    }
    
    public class BoutonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) { 
            //Si l'utilisateur clique sur un bouton "Accueil" (peut importe la page)
            if (e.getSource() == Accueil.getjButtonAccueil() || e.getSource() == Admin.getjButtonAccueil() || e.getSource() == Aca.getjButtonAccueil()){
                Accueil.setVisible(true);
                Admin.setVisible(false);
                Aca.setVisible(false);  
            }
            
            //Si l'utilisateur clique sur un bouton "Administration" (peut importe la page)
            else if (e.getSource() == Accueil.getjButtonAdmin() || e.getSource() == Admin.getjButtonAdmin() || e.getSource() == Aca.getjButtonAdmin()){
                Accueil.setVisible(false);
                Admin.setVisible(true);
                Aca.setVisible(false);
            }
            
            //Si l'utilisateur clique sur un bouton "Académique" (peut importe la page)
            else if (e.getSource() == Accueil.getjButtonAca() || e.getSource() == Admin.getjButtonAca() || e.getSource() == Aca.getjButtonAca()){
                Accueil.setVisible(false);
                Admin.setVisible(false);
                Aca.setVisible(true);
            }
            
            //Connection à la bdd sur le bouton "Connecter" de la page d'accueil puis change vers Panel "connected"
            else if (e.getSource() == Accueil.getjButtonConnect()){
                boolean connect=false;
                boolean admin=false;
                ResultSet rs=null;
                try {
                    connect=javaprojet.model.bdd.GestionConnexion.userConnection(Accueil.getjTextFieldLogin().getText(),Accueil.getjPasswordFieldMdp().getText());
                    System.out.println("connect = "+connect);
                    admin=javaprojet.model.bdd.GestionConnexion.CheckAdmin(Accueil.getjTextFieldLogin().getText());
                    System.out.println("admin "+admin);
                    
                    if (connect == true){
                        CardLayout cl = (CardLayout)(Accueil.getjPanelMainContent().getLayout());
                        cl.next(Accueil.getjPanelMainContent());
                    }
                    
                    else {
                        JOptionPane.showMessageDialog(null, "Connection failed", "Erreur", JOptionPane.ERROR_MESSAGE);
			System.err.println("Utilisateur non trouve");
			System.out.println(Accueil.getjTextFieldLogin().getText());
                        
                    }
         
                } catch (SQLException ex) {
                    Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
                }

                String mdp = new String(Accueil.getjPasswordFieldMdp().getPassword());
                System.out.println(mdp);
                String login = Accueil.getjTextFieldLogin().getText();
                System.out.println(login);
                
            }
            
            //Bouton retour vers panel "connexion"
            else if (e.getSource() == Accueil.getjButtonDiscon()){

                CardLayout c2 = (CardLayout)(Accueil.getjPanelMainContent().getLayout());
                c2.next(Accueil.getjPanelMainContent());
                //Boîte du message d'information
                JOptionPane.showMessageDialog(null, "Déconnection", "Information", JOptionPane.INFORMATION_MESSAGE);
            }  
            
            //Boutton pour confirmer la classe à choisir dans le 1er combobox de la page Administration
            else if (e.getSource() == Admin.getjButtonokClasse()){
                System.out.println(Admin.getjComboBoxClasse().getSelectedItem());
        
                ResultSet resEtu=null;
                ResultSet resid=null;
                Statement stmt=null;
                int id= 0;
                try{
                    javaprojet.model.bdd.DBconnexion.connexionDB();
                    stmt= DBconnexion.getConn().createStatement();
                    //PERMET DE RECUPERER L'ID DE LA CLASSSE POUR PERMETTRE DE REMPLIR LA COMBOBOX ETUDIANT
                    String idClasse="SELECT idCLasse FROM `classe` WHERE NomClasse='"+Admin.getjComboBoxClasse().getSelectedItem()+"'";
                    resid=stmt.executeQuery(idClasse);
                    resid.first();
                    id=Integer.parseInt(resid.getString("idClasse"));
                    System.out.println("idClasse="+id);
                    String EtuSelect="SELECT * FROM `etudiant` WHERE idClasse="+id+"";
                    System.out.println("DEBUG / USERLOGIN REQUEST"+EtuSelect);
                    resEtu=stmt.executeQuery(EtuSelect);
                    Admin.getjComboBoxEtu().setModel(new javax.swing.DefaultComboBoxModel<>());
                    
                    while(resEtu.next()){
                        Admin.getjComboBoxEtu().addItem(resEtu.getString("NOM")+" "+resEtu.getString("PRENOM"));
                    }
                    stmt.close();
                }
                catch (SQLException SQLe) {
                    System.out.println("Probleme lors de la recherche dans la BDD "+SQLe.getMessage());

                }
            }
            
            //Boutton pour confirmer la classe à choisir dans le 2eme combobox de la page Académique
            else if (e.getSource() == Admin.getjButtonchoixETU()){
                ResultSet resEtu=null;
                ResultSet resid=null;
                Statement stmt=null;
                int idEtudiant=0;
                String[] NameEtudiant= Admin.getjComboBoxEtu().getSelectedItem().toString().split(" ");
                System.out.println("idEtudiantSelection: "+NameEtudiant[0]);
                try{
                    javaprojet.model.bdd.DBconnexion.connexionDB();
                    stmt= DBconnexion.getConn().createStatement();
                    //PERMET DE RECUPERER LE MATRICULE DE L'ETUDIANT
                    String Matricule="SELECT MATRICULE FROM `etudiant` WHERE NOM='"+NameEtudiant[0]+"'";
                    resid=stmt.executeQuery(Matricule);
                    resid.first();
                    idEtudiant=Integer.parseInt(resid.getString("MATRICULE"));
                    System.out.println("Matricule="+idEtudiant);
                    String Recup_etudiant_info="SELECT * FROM `etudiant` LEFT JOIN responsable ON (etudiant.MATRICULE=responsable.Matricule) \n" +
"						 LEFT JOIN identite ON (etudiant.MATRICULE=identite.Matricule)\n" +
"						 LEFT JOIN coordonnees ON (etudiant.MATRICULE=coordonnees.Matricule)\n" +
"						 LEFT JOIN sante ON (etudiant.MATRICULE=sante.Matricule)\n" +
"						 WHERE etudiant.MATRICULE="+idEtudiant+"";
                resEtu=stmt.executeQuery(Recup_etudiant_info);
                resEtu.first();
                //Donne les valeurs associé à l'étudiant dans les différents objet associé
                etu.setMatricule(Integer.parseInt(resEtu.getString("MATRICULE")));
                etu.setNom(resEtu.getString("NOM"));
                etu.setPrenom(resEtu.getString("PRENOM"));
                etu.setIdClasse(Integer.parseInt(resEtu.getString("idClasse")));
                System.out.println("test requete"+resEtu.getString("PRENOM"));
                //Associe les valeurs de cette etudiant dans l'objet identité
                i.setMatricule(idEtudiant);
                i.setDateInscription(resEtu.getString("DateInscription"));
                i.setDateNaissance(resEtu.getString("DateNaissance"));
                i.setEtablissementpr(resEtu.getString("Etablissementpr"));
                i.setPaysNaissance(resEtu.getString("PaysNaissance"));
                i.setSexe(resEtu.getString("Sexe"));
                i.setVilleNaissance(resEtu.getString("VilleNaissance"));
               
                //
                c.setMatricule(idEtudiant);
                c.setAdresse(resEtu.getString("Adresse"));
                c.setCodePostal(Integer.parseInt(resEtu.getString("CodePostal")));
                c.setVille(resEtu.getString("Ville"));
                c.setEmail(resEtu.getString("Email"));
                c.setTeldom(resEtu.getString("Teldom"));
                c.setTelmobile(resEtu.getString("Telmobile"));
                //
                s.setMatricule(idEtudiant);
                s.setMedecinTraitant(resEtu.getString("MédecinTraitant"));
                s.setTelMedecin(resEtu.getString("TelMedecin"));
                s.setVaccinations(resEtu.getString("Vaccinations"));
                s.setAllergies(resEtu.getString("Allergies"));
                s.setRemarquesMedicales(resEtu.getString("RemarquesMedicales"));
                //
                r1.setIdResponsable(Integer.parseInt(resEtu.getString("IdResponsable")));
                r1.setNom(resEtu.getString("NomRes"));
                r1.setPrenom(resEtu.getString("PrenomRes"));
                r1.setAdresse(resEtu.getString("AdresseRes"));
                r1.setTelephone(resEtu.getString("TelephoneRes"));
                r1.setEmail(resEtu.getString("EmailRes"));
                //Dans le cas d'un deuxieme responsable
                if(resEtu.next()==true)
                {
                    
                    r2.setIdResponsable(Integer.parseInt(resEtu.getString("IdResponsable")));
                    r2.setNom(resEtu.getString("NomRes"));
                    r2.setPrenom(resEtu.getString("PrenomRes"));
                    r2.setAdresse(resEtu.getString("AdresseRes"));
                    r2.setTelephone(resEtu.getString("TelephoneRes"));
                    r2.setEmail(resEtu.getString("Email"));
                
                }
                //si pas de responsable2 , mettre a vide les champs du reponsable deux
                else{
                    r2.setIdResponsable(0);
                    r2.setNom("  ");
                    r2.setPrenom("  ");
                    r2.setAdresse("  ");
                    r2.setTelephone("  ");
                    r2.setEmail("  ");
                    
                    
                }
                
                
                
                Admin.getjTextFieldMat().setText(Integer.toString(etu.getMatricule()));
                Admin.getjTextFieldNom().setText(etu.getNom());
                Admin.getjTextFieldPrenom1().setText(etu.getPrenom());
                
                Admin.getjTextFieldAdr().setText(c.getAdresse());
                
                Admin.getjTextFieldContact1Adr().setText(r1.getAdresse());
                Admin.getjTextFieldContact1Mail().setText(r1.getEmail());
                Admin.getjTextFieldContact1Nom().setText(r1.getNom());
                Admin.getjTextFieldContact1Prenom().setText(r1.getPrenom());
                Admin.getjTextFieldContact1Tel().setText(r1.getTelephone());
                
                Admin.getjTextFieldContact2Adr().setText(r2.getAdresse());
                Admin.getjTextFieldContact2Mail().setText(r2.getEmail());
                Admin.getjTextFieldContact2Nom().setText(r2.getNom());
                Admin.getjTextFieldContact2Prenom().setText(r2.getPrenom());
                Admin.getjTextFieldContact2Tel().setText(r2.getTelephone());
                
                Admin.getjTextFieldCp().setText(Integer.toString(c.getCodePostal()));
                Admin.getjTextFieldDateInsc().setText(i.getDateInscription());
                Admin.getjTextFieldDateNais().setText(i.getDateNaissance());
                Admin.getjTextFieldEtaPre().setText(i.getEtablissementpr());
                Admin.getjTextFieldPaysNais().setText(i.getPaysNaissance());
                
                Admin.getjTextFieldMail().setText(c.getEmail());
                Admin.getjTextFieldSexe().setText(i.getSexe());
                Admin.getjTextFieldTelDom().setText(c.getTeldom());
                Admin.getjTextFieldTelMob().setText(c.getTelmobile());
                Admin.getjTextFieldVille().setText(c.getVille());
                Admin.getjTextFieldVilleNais().setText(i.getVilleNaissance());
                Admin.getjTextFieldDateNais().setText(i.getDateNaissance());
               
                //parser nommedecintraitant
                String[] NameMedecin= s.getMedecinTraitant().split(" ");
                Admin.getjTextFieldNomMed().setText(NameMedecin[0]);
                Admin.getjTextFieldPrenomMed().setText(NameMedecin[1]);
                Admin.getjTextFieldRem().setText(s.getRemarquesMedicales());
                Admin.getjTextFieldVacc().setText(s.getVaccinations());
                Admin.getjTextFieldAll().setText(s.getAllergies());
                Admin.getjTextFieldTelMed().setText(s.getTelMedecin());
               
                /*
             
               System.out.println(etu.getMatricule());
               System.out.println(etu.getNom());
               System.out.println(etu.getPrenom());
               System.out.println(etu.getIdClasse());*/
               System.out.println(r2.getAdresse());
               System.out.println(etu.getPrenom());
                }
                catch (SQLException SQLe) {
                    System.out.println("Probleme lors de la recherche dans la BDD "+SQLe.getMessage());
                }
        
            }
            else if (e.getSource() == Aca.getjButtonOkMatiere()){
                System.out.println(Aca.getjComboBoxMatiere().getSelectedItem());
                ResultSet resEtu=null;
                ResultSet resid=null;
                Statement stmt=null;
                
                try{
                    javaprojet.model.bdd.DBconnexion.connexionDB();
                    stmt= DBconnexion.getConn().createStatement();
                    //PERMET DE RECUPERER LE MATRICULE DE L'ETUDIANT
                    String Matiere ="SELECT idMatiere FROM `matiere` WHERE nomMat='"+Aca.getjComboBoxMatiere().getSelectedItem()+"'";
                    resid=stmt.executeQuery(Matiere);
                    resid.first();
                    int idMatiere=Integer.parseInt(resid.getString("idMatiere"));
                    System.out.println("ID MATIERE ="+idMatiere);
                    String Recup_etudiant_info="SELECT * FROM `etudiant` LEFT JOIN classe ON (etudiant.idClasse=classe.idClasse) \n" +
"						 LEFT JOIN matiere ON (classe.idMatiere1=matiere.idMatiere OR classe.idMatiere2=matiere.idMatiere OR classe.idMatiere3=matiere.idMatiere OR classe.idMatiere4=matiere.idMatiere)\n" +
"                                                WHERE matiere.idMatiere="+idMatiere+"";
                    resEtu=stmt.executeQuery(Recup_etudiant_info);
                    Aca.getjComboBoxEtudiantMat().setModel(new javax.swing.DefaultComboBoxModel<>());
                    
                    while(resEtu.next()){
                        Aca.getjComboBoxEtudiantMat().addItem(resEtu.getString("NOM")+" "+resEtu.getString("PRENOM"));
                    }
                    stmt.close();
                    
                } catch (SQLException sqlE) {
                    System.out.println("Probleme lors de la recherche dans la BDD"+sqlE.getMessage());
                }

            }
            
             else if (e.getSource() == Aca.getjButtonChoixMatiere()){
                ResultSet resTable=null;
                ResultSet resid=null;
                ResultSet resEtu=null;
                Statement stmt=null;
                
                int idEtu=0, idMat=0;

                String[] NameEtudiant =  Aca.getjComboBoxEtudiantMat().getSelectedItem().toString().split(" ");
                System.out.println("NomSelection: "+NameEtudiant[0]);

                try{
                    javaprojet.model.bdd.DBconnexion.connexionDB();
                    stmt= DBconnexion.getConn().createStatement();
                    System.out.println("1");

                    String etudiant ="SELECT MATRICULE FROM `etudiant` WHERE NOM='"+NameEtudiant[0]+"'"; 
                    System.out.println(Aca.getjComboBoxEtudiantMat().getSelectedItem());
                    resEtu=stmt.executeQuery(etudiant);
                    System.out.println(Aca.getjComboBoxEtudiantMat().getSelectedItem());
                    resEtu.first();

                    
                    idEtu=Integer.parseInt(resEtu.getString("MATRICULE"));
                    System.out.println("idEtu="+idEtu);

                    
                    System.out.println(Aca.getjComboBoxMatiere().getSelectedItem());
                    
                    String MatriculeN="SELECT MATRICULE FROM `notes` LEFT JOIN `matiere`ON (notes.idMatiere=matiere.idMatiere)WHERE NomMat='"+Aca.getjComboBoxMatiere().getSelectedItem()+"'";
                    resid=stmt.executeQuery(MatriculeN);
                    resid.first();
                    idMat = Integer.parseInt(resid.getString("MATRICULE"));
                    System.out.println("1");
                    System.out.println("idEtuMatricule="+idEtu);
                    System.out.println("Matricule="+idMat);
                    String Recup_notes_info="SELECT NOM, PRENOM, nomMat, moyenne, NomClasse FROM `etudiant` LEFT JOIN classe ON (etudiant.idClasse=classe.idClasse)  \n" +
"						 LEFT JOIN notes ON(notes.idMatiere=classe.idMatiere1 OR notes.idMatiere=classe.idMatiere2 OR notes.idMatiere=classe.idMatiere3 OR notes.idMatiere=classe.idMatiere4)\n" +
"						 LEFT JOIN matiere ON (matiere.idMatiere=notes.idMatiere)\n" +
"						 WHERE etudiant.MATRICULE="+idEtu+" AND notes.MATRICULE="+idEtu+"";

                    resTable=stmt.executeQuery(Recup_notes_info);
                       
                    
                    //Utilisation de rs2xml.jar pour générer un tableau
                    Aca.getjTableNotes().setModel(DbUtils.resultSetToTableModel(resTable));

                }
                catch (SQLException SQLe) {
                    System.out.println("Probleme lors de la recherche dans la BDD "+SQLe.getMessage());
                }
             }
             //permet de modifier les informations general 
            else if (e.getSource() == Admin.getjButtonModifyGeneral()){
                
                etu.setMatricule(Integer.parseInt(Admin.getjTextFieldMat().getText()));
                etu.setNom(Admin.getjTextFieldNom().getText());
                etu.setPrenom(Admin.getjTextFieldPrenom1().getText());
                GestionEtudiant.updateEtudiant(etu);
              
            }
            // permet de modifier l'identité
            else if (e.getSource() == Admin.getjButtonModifyIdent()){
                i.setMatricule(Integer.parseInt(Admin.getjTextFieldMat().getText()));
                i.setDateInscription(Admin.getjTextFieldDateInsc().getText());
                i.setDateNaissance(Admin.getjTextFieldDateNais().getText());
                i.setEtablissementpr(Admin.getjTextFieldEtaPre().getText());
                i.setPaysNaissance(Admin.getjTextFieldPaysNais().getText());
                i.setSexe(Admin.getjTextFieldSexe().getText());
                i.setVilleNaissance(Admin.getjTextFieldVilleNais().getText());
                GestionIdentite.updateIdentite(i);
            }
            
            //permet de modifier les coordonnées 
            else if (e.getSource() == Admin.getjButtonModifyCoord()){
                c.setMatricule(Integer.parseInt(Admin.getjTextFieldMat().getText()));
                c.setAdresse(Admin.getjTextFieldAdr().getText());
                c.setCodePostal(Integer.parseInt(Admin.getjTextFieldCp().getText()));
                c.setVille(Admin.getjTextFieldVille().getText());
                c.setEmail(Admin.getjTextFieldMail().getText());
                c.setTeldom(Admin.getjTextFieldTelDom().getText());
                c.setTelmobile(Admin.getjTextFieldTelMob().getText());
                GestionCoordonnees.updateCoordonnees(c);
            }
            //permet de modifier le reponsable 1
            else if (e.getSource() == Admin.getjButtonModifyR1()){
                r1.setNom(Admin.getjTextFieldContact1Nom().getText());
                r1.setPrenom(Admin.getjTextFieldContact1Prenom().getText());
                r1.setAdresse(Admin.getjTextFieldContact1Adr().getText());
                r1.setTelephone(Admin.getjTextFieldContact1Tel().getText());
                r1.setEmail(Admin.getjTextFieldContact1Mail().getText());
                GestionResponsable.updateResponsable(r1);
            }
            //permet de modifier le reponsable 2
            else if (e.getSource() == Admin.getjButtonModifyR2()){
                
                r2.setNom(Admin.getjTextFieldContact2Nom().getText());
                r2.setPrenom(Admin.getjTextFieldContact2Prenom().getText());
                r2.setAdresse(Admin.getjTextFieldContact2Adr().getText());
                r2.setTelephone(Admin.getjTextFieldContact2Tel().getText());
                r2.setEmail(Admin.getjTextFieldContact2Mail().getText());
                GestionResponsable.updateResponsable(r2);
            }
            //permet de modifier le reponsable medicale
            else if (e.getSource() == Admin.getjButtonModifyMed()){
                s.setMatricule(Integer.parseInt(Admin.getjTextFieldMat().getText()));
                s.setMedecinTraitant(Admin.getjTextFieldNomMed().getText()+" "+Admin.getjTextFieldPrenomMed().getText());
                s.setTelMedecin(Admin.getjTextFieldTelMed().getText());
                s.setVaccinations(Admin.getjTextFieldVacc().getText());
                s.setAllergies(Admin.getjTextFieldAll().getText());
                s.setRemarquesMedicales(Admin.getjTextFieldRem().getText());
                GestionSante.updateSante(s);
            }
            else if (e.getSource() == Admin.getjButtonDocEdit()){
                String[] result= Admin.getjComboBoxDocEtu().getSelectedItem().toString().split(" ");
                String date= Admin.getjTextFieldDocDate().getText();
                String motif=Admin.getjTextFieldDocMotif().getText();
                
                Statement stmt=null;
                ResultSet resEtudiant=null; 
                try{
                javaprojet.model.bdd.DBconnexion.connexionDB();
                stmt= DBconnexion.getConn().createStatement();
                String EtuSelect="SELECT * FROM `etudiant` WHERE NOM='"+result[0] +"'";
                System.out.println("DEBUG / USERLOGIN REQUEST  "+EtuSelect);
                resEtudiant=stmt.executeQuery(EtuSelect);
                resEtudiant.first();
                etuDoc.setMatricule(Integer.parseInt(resEtudiant.getString("MATRICULE")));
                etuDoc.setNom(resEtudiant.getString("NOM"));
                etuDoc.setPrenom(resEtudiant.getString("PRENOM"));
                etuDoc.setIdClasse(Integer.parseInt(resEtudiant.getString("idClasse")));
                } catch (SQLException sqlE) {
                    System.out.println("Probleme BDD :"+sqlE.getMessage());
                }
                GestionDocument.GestionDocument(etuDoc, motif, Date.valueOf(date),"./DocumentPDF/Convocation_"+etuDoc.getNom()+"_"+etuDoc.getPrenom()+".pdf");
                Desktop desk = Desktop.getDesktop();
                try {
                    desk.open(new File("./DocumentPDF/Convocation_"+etuDoc.getNom()+"_"+etuDoc.getPrenom()+".pdf"));
                } catch (IOException Fe) {
                    JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, "Probleme lors de l'ouverture du pdf"+Fe.getMessage(), "Erreur Ouverture", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Probleme lors de l'ouverture du pdf"+Fe.getMessage());
                    
                }
                }
            //Permet d'imprimer la convocation
            else if (e.getSource() == Admin.getjButtonDocImpr()){
                
                Desktop desk = Desktop.getDesktop();
                if (Desktop.isDesktopSupported()){  
                    if(Desktop.getDesktop().isSupported(java.awt.Desktop.Action.PRINT)){  
                        try {  
                                java.awt.Desktop.getDesktop().print(new File("./DocumentPDF/Convocation_"+etuDoc.getNom()+"_"+etuDoc.getPrenom()+".pdf")); 
                                JOptionPane jop1 = new JOptionPane();
                                jop1.showMessageDialog(null, "L'impression est en cours", "Impression", JOptionPane.INFORMATION_MESSAGE);
                         
                        } catch (IOException Fe) {  
                                JOptionPane jop1 = new JOptionPane();
                                jop1.showMessageDialog(null, "Probleme lors de l'impression du pdf"+Fe.getMessage(), "Erreur Impression", JOptionPane.ERROR_MESSAGE);
                        }  
                    }else {  
                                //La fonction n'est pas supportée par votre système d'exploitation
                                JOptionPane jop1 = new JOptionPane();
                                jop1.showMessageDialog(null, "La fonction n'est pas supporté par votre systeme d'exploitation", "Erreur Impression", JOptionPane.ERROR_MESSAGE);
                            }  
                }   
            }
            
            else if (e.getSource() == Aca.getjButtonReChoixClasse()){
                System.out.println(Aca.getjComboBoxReClasse().getSelectedItem());
        
                ResultSet resEtu=null;
                ResultSet resid=null;
                Statement stmt=null;
                int id= 0;
                try{
                    javaprojet.model.bdd.DBconnexion.connexionDB();
                    stmt= DBconnexion.getConn().createStatement();
                    //PERMET DE RECUPERER L'ID DE LA CLASSSE POUR PERMETTRE DE REMPLIR LA COMBOBOX ETUDIANT
                    String idClasse="SELECT idCLasse FROM `classe` WHERE NomClasse='"+Aca.getjComboBoxReClasse().getSelectedItem()+"'";
                    resid=stmt.executeQuery(idClasse);
                    resid.first();
                    id=Integer.parseInt(resid.getString("idClasse"));
                    System.out.println("idClasse="+id);
                    String EtuSelect="SELECT * FROM `etudiant` WHERE idClasse="+id+"";
                    System.out.println("DEBUG / USERLOGIN REQUEST"+EtuSelect);
                    resEtu=stmt.executeQuery(EtuSelect);
                    Aca.getjComboBoxReEtu().setModel(new javax.swing.DefaultComboBoxModel<>());
                    
                    while(resEtu.next()){
                        Aca.getjComboBoxReEtu().addItem(resEtu.getString("NOM")+" "+resEtu.getString("PRENOM"));
                    }
                    stmt.close();
                }
                catch (SQLException SQLe) {
                    System.out.println("Probleme lors de la recherche dans la BDD "+SQLe.getMessage());

                }
            }
             
            else if (e.getSource() == Aca.getjButtonReChoixEtu()){
                ResultSet resEtu=null;
                ResultSet resid=null;
                Statement stmt=null;
                int idEtudiant=0;
                String[] NameEtudiant= Aca.getjComboBoxReEtu().getSelectedItem().toString().split(" ");
                System.out.println("idEtudiantSelection: "+NameEtudiant[0]);
                
                try {
                    javaprojet.model.bdd.DBconnexion.connexionDB();
                    stmt= DBconnexion.getConn().createStatement();
                    //PERMET DE RECUPERER LE MATRICULE DE L'ETUDIANT
                    String Matricule="SELECT MATRICULE FROM `etudiant` WHERE NOM='"+NameEtudiant[0]+"'";
                    resid=stmt.executeQuery(Matricule);
                    resid.first();
                    idEtudiant=Integer.parseInt(resid.getString("MATRICULE"));
                   
                } catch (SQLException SQLe) {
                    System.out.println("Probleme lors de la recherche dans la BDD "+SQLe.getMessage());
                }
                    
                
                
            }
                
        }
    }
}