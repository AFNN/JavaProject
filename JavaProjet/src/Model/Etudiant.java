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
    private String Prénom;
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

    public String getPrénom() {
        return Prénom;
    }

    public void setPrénom(String Prénom) {
        this.Prénom = Prénom;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public Etudiant(int Matricule, String Nom, String Prénom, int idClasse) {
        this.Matricule = Matricule;
        this.Nom = Nom;
        this.Prénom = Prénom;
        this.idClasse = idClasse;
    }
    
    
    
}
