/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.GestionClasse.updateClasse;
import model.Etudiant;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Classe;

/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class GestionEtudiant {
    
    
    
    public static void addEtudiant(Etudiant E){
        
        try {
                DBconnexion.connexionDB();
                Statement stmt = (Statement) DBconnexion.getConn().createStatement();
		String insert = "INSERT INTO etudiant (NOM, PRENOM, idClasse) VALUES ('" + E.getNom() +"','" +E.getPrenom()+"','" +E.getIdClasse()+"')";
		stmt.executeUpdate(insert);
		System.out.println("Etudiant ajouté à la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
        }
    }
     
    public static void updateEtudiant(Etudiant E){
        
        try {
                DBconnexion.connexionDB();
                Statement stmt = (Statement) DBconnexion.getConn().createStatement();
		String update = " ";
                stmt.executeUpdate(update);
		System.out.println("Etudiant ajouté à la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
        }
    }
    
    
    /**
     *
     * @param args
     * @throws SQLException
     */
     public static void main(String[] args) throws SQLException {
        Etudiant e= new model.Etudiant(0, "Nom", "Prénom", 1);
         
            addEtudiant(e);
        
    
    
    
}}
