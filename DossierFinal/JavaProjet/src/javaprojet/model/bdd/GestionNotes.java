/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.model.bdd;
import java.sql.*;
import javaprojet.model.donnee.Notes;
import javax.swing.JOptionPane;


/**
 *
 * @author Arnaud Fouillard 
 */
public class GestionNotes {
    /**
     * Permet d'ajouter une note en base de donnée
     * @param n 
     */
    public static void addNotes(Notes n){
        try {
                DBconnexion.connexionDB();
                Statement stmt =  DBconnexion.getConn().createStatement();
		String insert = "INSERT INTO `notes` (`moyenne`, `Matricule`, `idMatière`) VALUES ("+n.getMoyenne() +", "+n.getMatricule() +", "+n.getIdMatière() +");";
		stmt.executeUpdate(insert);
		System.out.println("Ajout de notes à la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
        }
        
        
        
    }
    /**
     * Permet de mettre a jour une note dans la base de donnée
     * @param n 
     */
    public static void updateNotes(Notes n){
        try {
                DBconnexion.connexionDB();
                Statement stmt =  DBconnexion.getConn().createStatement();
		String update = "UPDATE `notes` SET `moyenne` = "+n.getMoyenne()+" WHERE `notes`.`Matricule` ="+n.getMatricule()+" AND `notes`.`idMatiere` = "+n.getIdMatière();
                stmt.executeUpdate(update);
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Notes mis à jour dans la base de donnée", "Ajout BDD", JOptionPane.INFORMATION_MESSAGE);
		
		System.out.println("Notes  mis  à jour dans la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de la mise a jour dans la base : "+SQLe.getMessage());
            JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, SQLe.getMessage(), "Erreur BDD", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }
    
}
