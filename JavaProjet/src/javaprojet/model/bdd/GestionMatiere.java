/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.model.bdd;
import java.sql.*;
import javaprojet.model.donnee.Matiere;
/**
 *
 * @author Arnaud Fouillard 
 */
public class GestionMatiere {
    /**
     * Permet d'ajouter une matiere dans la base de donnée
     * @param m 
     */
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
    /**
     * Permet de mettre a jour une matiere
     * @param m 
     */
    public static void updateMatiere(Matiere m){
        try {
                DBconnexion.connexionDB();
                Statement stmt =  DBconnexion.getConn().createStatement();
		String update = "UPDATE `matiere` SET `nomMat` = '"+m.getNomMat()+"' WHERE `matiere`.`idMatiere` = "+m.getIdMatiere(); 
                stmt.executeUpdate(update);
		System.out.println("Matiere mise à jour dans la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
        }
        
    
    
    }
    
}
