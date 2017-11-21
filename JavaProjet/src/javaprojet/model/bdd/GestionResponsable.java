/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.model.bdd;

import javaprojet.model.donnee.Responsable;
import java.sql.*;

/**
 *
 * @author Arnaud Fouillard 
 */
public class GestionResponsable {
    /**
     * Permet d'ajouter un responsable dans la base de donnée
     * @param r 
     */
    public static void addResponsable(Responsable r){
        try {
                DBconnexion.connexionDB();
                Statement stmt =  DBconnexion.getConn().createStatement();
		String insert = "INSERT INTO `responsable` (`IdResponsable`, `Nom`, `Prenom`, `Adresse`, `Telephone`, `Email`, `Matricule`) VALUES (0,"+r.getNom()+" , "+r.getPrenom()+", "+r.getAdresse()+", "+r.getTelephone()+", "+r.getEmail()+", "+r.getMatricule()+")";
		stmt.executeUpdate(insert);
		System.out.println("Etudiant ajouté à la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
        }
        
        
    }
    /**
     * Permet de mettre a jour un responsable dans la base de donnée
     * @param r 
     */
    public static void updateResponsable(Responsable r){
        try {
                DBconnexion.connexionDB();
                Statement stmt = DBconnexion.getConn().createStatement();
		String update = "UPDATE `responsable` SET `Nom` = "+r.getNom()+", `Prenom` = "+r.getPrenom()+", `Adresse` = "+r.getAdresse()+", `Telephone` = "+r.getTelephone()+", `Email` = "+r.getEmail()+" WHERE `responsable`.`IdResponsable` = "+r.getIdResponsable()+";";
                stmt.executeUpdate(update);
		System.out.println("Etudiant mis à jour dans la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
        }
        
        
    }
    
}
