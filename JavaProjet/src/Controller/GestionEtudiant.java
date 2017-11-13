/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import model.Etudiant;
import java.sql.*;


/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class GestionEtudiant {
    
    
    
    public static void addEtudiant(Etudiant E){
        
        try {
                DBconnexion.connexionDB();
                Statement stmt =  DBconnexion.getConn().createStatement();
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
                Statement stmt = DBconnexion.getConn().createStatement();
		String update = "UPDATE etudiant SET NOM = " + E.getNom()+", PRENOM = " + E.getPrenom()+ ", idClasse = " +E.getIdClasse()+ " WHERE etudiant.MATRICULE = " + E.getMatricule(); 
                stmt.executeUpdate(update);
		System.out.println("Etudiant mis à jour dans la base de donnée");
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
        Etudiant e= new model.Etudiant(5, "Nom", "Prenom", 4);
         
            updateEtudiant(e);
        
    
    
    
}}
