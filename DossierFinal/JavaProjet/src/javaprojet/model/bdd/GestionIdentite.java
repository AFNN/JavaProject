/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.model.bdd;


import java.sql.*;
import javaprojet.model.donnee.Identite;
import javax.swing.JOptionPane;

/**
 *
 * @author Arnaud Fouillard 
 */
public class GestionIdentite {
    
    /**
     * Permet d'ajouter l'identite d'un etudiant
     * @param I 
     */
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
    /**
     * Permet de mettre a jour l'identite d'un etudiant
     * @param I 
     */
    public static void updateIdentite(Identite I){
        try {
                DBconnexion.connexionDB();
                Statement stmt = (Statement) DBconnexion.getConn().createStatement();
		String update = "UPDATE `identite` SET `DateNaissance` = '"+I.getDateNaissance()+"',`VilleNaissance` ='"+ I.getVilleNaissance() +"',`PaysNaissance` = '"+ I.getPaysNaissance()+"', `Sexe` = '"+ I.getSexe()+"', `DateInscription` = '"+ I.getDateInscription()+"', `Etablissementpr` = '"+I.getEtablissementpr()+"', `Matricule` = "+I.getMatricule()+" WHERE `identite`.`Matricule` ="+I.getMatricule();
                System.out.println(update);
                stmt.executeUpdate(update);
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Identite Etudiant mis à jour dans la base de donnée", "Ajout BDD", JOptionPane.INFORMATION_MESSAGE);
		System.out.println("Identite Etudiant  mis  à jour dans la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de la mise a jour dans la base : "+SQLe.getMessage());
            JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, SQLe.getMessage(), "Erreur BDD", JOptionPane.ERROR_MESSAGE);
        }
    }
}
