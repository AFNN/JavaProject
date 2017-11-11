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
public class Responsable {
    
    private int idReprsponsable;
    private String nom; 
    private String prenom; 
    private String adresse; 
    private int telephone;
    private int email; 
    private int matricule;

    public int getIdReprsponsable() {
        return idReprsponsable;
    }

    public void setIdReprsponsable(int idReprsponsable) {
        this.idReprsponsable = idReprsponsable;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public Responsable(int idReprsponsable, String nom, String prenom, String adresse, int telephone, int email, int matricule) {
        this.idReprsponsable = idReprsponsable;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.matricule = matricule;
    }

    
}
