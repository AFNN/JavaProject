/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class Etudiant {
    
    private int Matricule;
    private String Nom;
    private String Prenom;
    private int idClasse;

    public int getMatricule() {
        return Matricule;
    }

    public void setMatricule(int Matricule) {
        this.Matricule = Matricule;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prénom) {
        this.Prenom = Prenom;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public Etudiant(int Matricule, String Nom, String Prenom, int idClasse) {
        this.Matricule = Matricule;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.idClasse = idClasse;
    }
    
    
    
}
