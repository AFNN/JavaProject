/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.*;
import model.Sante;

/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class GestionSante {
    
    public static void addSante(Sante s){
        try {
                DBconnexion.connexionDB();
                Statement stmt =  DBconnexion.getConn().createStatement();
		String insert = "INSERT INTO `sante` (`MédecinTraitant`, `TelMedecin`, `Vaccinations`, `Allergies`, `RemarquesMedicales`, `MATRICULE`) VALUES ("+s.getMedecinTraitant()+","+s.getTelMedecin()+","+s.getVaccinations()+","+s.getAllergies()+","+s.getRemarquesMedicales()+","+s.getMatricule()+")";
		stmt.executeUpdate(insert);
		System.out.println("Rubrique sante mis dans la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
        }
        
    }
    
    public static void updateSante(Sante s){
        try {
                DBconnexion.connexionDB();
                Statement stmt = DBconnexion.getConn().createStatement();
		String update = "UPDATE `sante` SET `MédecinTraitant` = "+s.getMedecinTraitant()+", `TelMedecin` = "+s.getTelMedecin()+", `Vaccinations` = "+s.getVaccinations()+", `Allergies` = "+s.getAllergies()+", `RemarquesMedicales` = "+s.getRemarquesMedicales()+" WHERE `sante`.`MATRICULE` = "+s.getMatricule()+";";
                stmt.executeUpdate(update);
		System.out.println("Rubrique sante  mis  à jour dans la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de la mise a jour dans la base : "+SQLe.getMessage());
        }
        
    }
    
}
