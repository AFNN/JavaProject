/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import model.Coordonnees;

/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class GestionCoordonnees {
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
    
    public static void updateCoordonnees(Coordonnees coor){
        try {
                DBconnexion.connexionDB();
                Statement stmt = DBconnexion.getConn().createStatement();
		String update = "UPDATE `coordonnees` SET `Adresse` = "+coor.getAdresse()+", `CodePostal` = "+coor.getCodePostal()+", `Ville` = "+coor.getVille()+", `Teldom` = "+coor.getTeldom()+", `Telmobile` = "+coor.getTelmobile()+", `Email` = "+coor.getEmail()+" WHERE `coordonnees`.`Matricule` = "+coor.getMatricule();
                stmt.executeUpdate(update);
		System.out.println("Coordonnées mis à jour dans la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
        }
        
        
        
    }
    
   
    
}
