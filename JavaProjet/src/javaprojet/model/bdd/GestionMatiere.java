/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.model.bdd;
import java.sql.*;
import javaprojet.model.donnee.Matiere;
import javax.swing.JOptionPane;
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
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Matiere mis à jour dans la base de donnée", "Ajout BDD", JOptionPane.INFORMATION_MESSAGE);
		
		System.out.println("Matiere mise à jour dans la base de donnée");
                
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
            JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, SQLe.getMessage(), "Erreur BDD", JOptionPane.ERROR_MESSAGE);
        }
        
    
    
    }
    
}
