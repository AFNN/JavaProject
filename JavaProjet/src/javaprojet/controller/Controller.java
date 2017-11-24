/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaprojet.view.Accueil;
import javaprojet.view.Accueil_1;
import javaprojet.view.Accueil_2;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class Controller {
    BoutonListener blistener = new BoutonListener();
    Accueil Accueil = new Accueil();
    Accueil_1 Admin = new Accueil_1();
    Accueil_2 Aca = new Accueil_2();
    
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
        
        // Création d'évènement sur les bouttons de la page Académique
        Aca.getjButtonAccueil().addActionListener(blistener);
        Aca.getjButtonAdmin().addActionListener(blistener);
        Aca.getjButtonAca().addActionListener(blistener);
        
        
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
                System.out.println("connect2 = "+connect);
                
            }
            
            //Bouton retour vers panel "connexion"
            else if (e.getSource() == Accueil.getjButtonDiscon()){
                
                
                CardLayout c2 = (CardLayout)(Accueil.getjPanelMainContent().getLayout());
                c2.next(Accueil.getjPanelMainContent());
                //Boîte du message d'information
                JOptionPane.showMessageDialog(null, "Déconnection", "Information", JOptionPane.INFORMATION_MESSAGE);
                
                
            }     
        }
    }
}