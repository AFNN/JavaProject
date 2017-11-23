/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.Printer;
import javaprojet.view.Accueil;
import javaprojet.view.Accueil_1;
import javaprojet.view.Accueil_2;
import javax.swing.JButton;

/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class Controller {
    BoutonListener blistener = new BoutonListener();
    Accueil Accueil = new Accueil();
    Accueil_1 Admin = new Accueil_1();
    Accueil_2 Aca = new Accueil_2();
   
    public Controller(){
        Accueil.getjButtonAccueil().addActionListener(blistener);
        Accueil.getjButtonAdmin().addActionListener(blistener);
        Accueil.getjButtonAca().addActionListener(blistener);
        
        Admin.getjButtonAccueil().addActionListener(blistener);
        Admin.getjButtonAdmin().addActionListener(blistener);
        Admin.getjButtonAca().addActionListener(blistener);
        
        Aca.getjButtonAccueil().addActionListener(blistener);
        Aca.getjButtonAdmin().addActionListener(blistener);
        Aca.getjButtonAca().addActionListener(blistener);
        
        Accueil.setVisible(true);

	//this.Connection=Connection;
	//Connection.getjButtonConnect().addActionListener(new BoutonListenerConnect());
		
    }

    public class BoutonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) { 
            if (e.getSource() == Accueil.getjButtonAccueil() || e.getSource() == Admin.getjButtonAccueil() || e.getSource() == Aca.getjButtonAccueil()){
                Accueil.setVisible(true);
                Admin.setVisible(false);
                Aca.setVisible(false);  
            }
            else if (e.getSource() == Accueil.getjButtonAdmin() || e.getSource() == Admin.getjButtonAdmin() || e.getSource() == Aca.getjButtonAdmin()){
                Accueil.setVisible(false);
                Admin.setVisible(true);
                Aca.setVisible(false);
            }
            else if (e.getSource() == Accueil.getjButtonAca() || e.getSource() == Admin.getjButtonAca() || e.getSource() == Aca.getjButtonAca()){
                Accueil.setVisible(false);
                Admin.setVisible(false);
                Aca.setVisible(true);
            }
                    
                    
            /*
            boolean connect=false;
            boolean admin=false;
            ResultSet rs=null;
                
            try {
                connect=javaprojet.model.bdd.GestionConnexion.userConnection(boutonAccueil.getjTextFieldLogin().getText(),boutonAccueil.getjPasswordFieldMdp().getText());
                System.out.println("connect = "+connect);
                admin=javaprojet.model.bdd.GestionConnexion.CheckAdmin(boutonAccueil.getjTextFieldLogin().getText());
                System.out.println("admin "+admin);
                               
            } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            }

            String mdp = new String(boutonAccueil.getjPasswordFieldMdp().getPassword());
            System.out.println(mdp);
            String login = boutonAccueil.getjTextFieldLogin().getText();
            System.out.println(login);
		   	
    */
        }
    }
}