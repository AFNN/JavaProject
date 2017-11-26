/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.model.bdd;

import java.sql.*;
import javaprojet.model.donnee.Coordonnees;
import javax.swing.JOptionPane;

/**
 *
 * @author Arnaud Fouillard 
 */
public class GestionCoordonnees {
    /**
     * Cette méthode permet d'ajouter des coordonnees dans la base de donnée.<br>
     * Elle attend un objet Coordonnees en parametre.
     * @see Coordonnees
     * @param  coor 
     *          Coordonnees(String adresse, int codePostal, String ville, int teldom, int telmobile, String email, int matricule)
     */
    public static void addCoordonnees(Coordonnees coor){
        try {
                DBconnexion.connexionDB();
                Statement stmt =  DBconnexion.getConn().createStatement();
		String insert = "INSERT INTO `coordonnees` (`Adresse`, `CodePostal`, `Ville`, `Teldom`, `Telmobile`, `Email`, `Matricule`) VALUES ("+coor.getAdresse()+","+coor.getCodePostal()+", "+coor.getVille()+", "+coor.getTeldom()+", "+coor.getTelmobile()+", "+coor.getEmail()+","+coor.getMatricule()+");";
		stmt.executeUpdate(insert);
		System.out.println("Coordonnées ajouté à la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
        }
    }
    /**
     * Cette méthode permet de mettre a jour les coordonnées à la base de donnée.<br>
     * Elle attend un objet Coordonnees en parametre.
     * @see Coordonnees
     * @param  coor 
     *          Coordonnees(String adresse, int codePostal, String ville, int teldom, int telmobile, String email, int matricule)
     */
    public static void updateCoordonnees(Coordonnees coor){
        try {
                DBconnexion.connexionDB();
                Statement stmt = DBconnexion.getConn().createStatement();
		String update = "UPDATE `coordonnees` SET `Adresse` = '"+coor.getAdresse()+"', `CodePostal` = '"+coor.getCodePostal()+"', `Ville` = '"+coor.getVille()+"', `Teldom` = '"+coor.getTeldom()+"', `Telmobile` = '"+coor.getTelmobile()+"', `Email` = '"+coor.getEmail()+"' WHERE `coordonnees`.`Matricule` = "+coor.getMatricule();
                System.out.println(update);
                stmt.executeUpdate(update);
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Coordonnées mis à jour dans la base de donnée", "Ajout BDD", JOptionPane.INFORMATION_MESSAGE);
		System.out.println("Coordonnées mis à jour dans la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
            JOptionPane jop1 = new JOptionPane();
                 jop1.showMessageDialog(null, SQLe.getMessage(), "Erreur BDD", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }
    
   
    
}
