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
import javaprojet.view.Accueil;
import javaprojet.view.Connexion;

/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class Controller {
   Accueil Connection= new Accueil();
   
public Controller(Accueil Connection){
		this.Connection=Connection;
		Connection.getjButtonConnect().addActionListener(new BoutonListenerConnect());
		
	}

public class BoutonListenerConnect implements ActionListener{
		public void actionPerformed(ActionEvent e) {
                
                boolean connect=false;
                boolean admin=false;
                ResultSet rs=null;
                
            try {
                connect=javaprojet.model.bdd.GestionConnexion.userConnection(Connection.getjTextFieldLogin().getText(),Connection.getjPasswordFieldMdp().getText());
                System.out.println("connect = "+connect);
                admin=javaprojet.model.bdd.GestionConnexion.CheckAdmin(Connection.getjTextFieldLogin().getText());
                System.out.println("admin "+admin);
                               
            } catch (SQLException ex) {
                Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            }

		   	String mdp = new String(Connection.getjPasswordFieldMdp().getPassword());
                        System.out.println(mdp);
                        String login = Connection.getjTextFieldLogin().getText();
                        System.out.println(login);
		   	
    
}
}}