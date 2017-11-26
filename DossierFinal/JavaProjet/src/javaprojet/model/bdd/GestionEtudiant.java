/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.model.bdd;


import javaprojet.model.donnee.Etudiant;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Arnaud Fouillard 
 */
public class GestionEtudiant {
    
    /**
     * Permet d'ajouter un etudiant dans la base de donnée 
     * @param E 
     */
    
    public static void addEtudiant(Etudiant E){
        
        try {
                DBconnexion.connexionDB();
                Statement stmt =  DBconnexion.getConn().createStatement();
		String insert = "INSERT INTO etudiant (NOM, PRENOM, idClasse) VALUES ('" + E.getNom() +"','" +E.getPrenom()+"','" +E.getIdClasse()+"')";
		stmt.executeUpdate(insert);
		System.out.println("Etudiant ajouté à la base de donnée");
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
            JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, SQLe.getMessage(), "Erreur BDD", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    /**
     * Permet de mettre a jour un Etudiant 
     * @param E 
     */
    public static void updateEtudiant(Etudiant E){
        
        try {
                DBconnexion.connexionDB();
                Statement stmt = DBconnexion.getConn().createStatement();
		String update = "UPDATE etudiant SET NOM = '" + E.getNom()+"', PRENOM = '" + E.getPrenom()+ "', idClasse = " +E.getIdClasse()+ " WHERE etudiant.MATRICULE = " + E.getMatricule(); 
                System.out.println(update);
                stmt.executeUpdate(update);
		System.out.println("Etudiant mis à jour dans la base de donnée");
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Coordonnées mis à jour dans la base de donnée", "Ajout BDD", JOptionPane.INFORMATION_MESSAGE);
		
        } catch (SQLException SQLe) {
            System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
            JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, SQLe.getMessage(), "Erreur BDD", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    /**
     *
     * @param args
     * @throws SQLException
     */
     public static void main(String[] args) throws SQLException {
        Etudiant e= new javaprojet.model.donnee.Etudiant(5, "Nom", "Prenom", 4);
         
            updateEtudiant(e);
        
    
    
    
}}
