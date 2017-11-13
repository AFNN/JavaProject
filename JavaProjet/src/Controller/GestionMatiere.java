/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.*;
import model.Matiere;
/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class GestionMatiere {
    
    public static void addMatiere(Matiere m){
        try {
                DBconnexion.connexionDB();
                Statement stmt =  DBconnexion.getConn().createStatement();
		String insert = "INSERT INTO `matiere` (`idMatiere`, `nomMat`) VALUES ("+m.getIdMatiere()+", "+m.getNomMat()+")";
		stmt.executeUpdate(insert);
		System.out.println("Matiere ajouté à la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
        }
    }
  
    public static void updateMatiere(Matiere m){
        try {
                DBconnexion.connexionDB();
                Statement stmt =  DBconnexion.getConn().createStatement();
		String update = "UPDATE `matiere` SET `nomMat` = "+m.getNomMat()+" WHERE `matiere`.`idMatiere` = "+m.getIdMatiere(); 
                stmt.executeUpdate(update);
		System.out.println("Matiere mise à jour dans la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
        }
        
    
    
    }
    
}
