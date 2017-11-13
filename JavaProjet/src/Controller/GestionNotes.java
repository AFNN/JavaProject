/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.*;
import model.Notes;


/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class GestionNotes {
    
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
    
    public static void updateNotes(Notes n){
        try {
                DBconnexion.connexionDB();
                Statement stmt =  DBconnexion.getConn().createStatement();
		String update = "UPDATE `notes` SET `moyenne` = "+n.getMoyenne()+" WHERE `notes`.`Matricule` ="+n.getMatricule()+" AND `notes`.`idMatière` = "+n.getIdMatière();
                stmt.executeUpdate(update);
		System.out.println("Notes  mis  à jour dans la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de la mise a jour dans la base : "+SQLe.getMessage());
        }
        
        
        
    }
    
}
