/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.sql.*;
import model.Identite;

/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class GestionIdentite {
    
    
    public static void addIdentite(Identite I){
        try {
                DBconnexion.connexionDB();
                Statement stmt = (Statement) DBconnexion.getConn().createStatement();
		String insert = "INSERT INTO identite (DateNaissance, VilleNaissance, PaysNaissance, Sexe, DateInscription, Etablissementpr , Matricule) VALUES ("+I.getDateNaissance()+","+ I.getVilleNaissance() +","+ I.getPaysNaissance()+","+ I.getSexe()+","+ I.getDateInscription()+","+I.getEtablissementpr()+","+I.getMatricule()+")";
		stmt.executeUpdate(insert);
		System.out.println("Identite Etudiant  ajouté à la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
        }
    }
    public static void updateIdentite(Identite I){
        try {
                DBconnexion.connexionDB();
                Statement stmt = (Statement) DBconnexion.getConn().createStatement();
		String update = "UPDATE `identite` SET `DateNaissance` = "+I.getDateNaissance()+",`VilleNaissance` ="+ I.getVilleNaissance() +",`PaysNaissance` = "+ I.getPaysNaissance()+", `Sexe` = "+ I.getSexe()+", `DateInscription` = "+ I.getDateInscription()+", `Etablissementpr` = "+I.getEtablissementpr()+", `Matricule` = "+I.getMatricule()+" WHERE `identite`.`Matricule` ="+I.getMatricule();
                stmt.executeUpdate(update);
		System.out.println("Identite Etudiant  mis  à jour dans la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de la mise a jour dans la base : "+SQLe.getMessage());
        }
    }
}
