/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.model.donnee;

/**
 *
 * @author Arnaud Fouillard 
 */
public class Responsable {
    
    private int idResponsable;
    private String nom; 
    private String prenom; 
    private String adresse; 
    private int telephone;
    private String email; 
    private int matricule;
    /**
     * 
     * @return idResponsable
     */
    public int getIdResponsable() {
        return idResponsable;
    }
    /**
     * 
     * @param idResponsable 
     */
    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }
    /**
     * 
     * @return nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * 
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * 
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * 
     * @param prenom 
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    /**
     * 
     * @return adresse
     */
    public String getAdresse() {
        return adresse;
    }
    /**
     * 
     * @param adresse 
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    /**
     * 
     * @return telephone
     */
    public int getTelephone() {
        return telephone;
    }
    /**
     * 
     * @param telephone 
     */
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    /**
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * 
     * @return matricule
     */
    public int getMatricule() {
        return matricule;
    }
    /**
     * 
     * @param matricule 
     */
    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }
    /**
     * Constructeur Responsable
     * @param idResponsable
     * @param nom
     * @param prenom
     * @param adresse
     * @param telephone
     * @param email
     * @param matricule 
     */
    public Responsable(int idResponsable, String nom, String prenom, String adresse, int telephone, String email, int matricule) {
        this.idResponsable = idResponsable;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.matricule = matricule;
    }

    
}
