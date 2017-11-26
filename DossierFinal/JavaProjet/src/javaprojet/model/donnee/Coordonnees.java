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
public class Coordonnees {
    private String adresse ;
    private int codePostal;
    private String ville ;
    private String teldom ;
    private String telmobile; 
    private String email ;
    private int matricule;

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
     * @return codePostal
     *      
     */
    public int getCodePostal() {
        return codePostal;
    }
    /**
     * 
     * @param codePostal 
     */
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }
    /**
     * 
     * 
     * @return ville
     */
    public String getVille() {
        return ville;
    }
    /**
     * 
     * @param ville 
     */
    public void setVille(String ville) {
        this.ville = ville;
    }
    /**
     * 
     * @return teldom
     */
    public String getTeldom() {
        return teldom;
    }
    /**
     * 
     * @param teldom 
     */
    public void setTeldom(String teldom) {
        this.teldom = teldom;
    }
    /**
     * 
     * @return telmobile
     */
    public String getTelmobile() {
        return telmobile;
    }
    /**
     * 
     * @param telmobile 
     */
    public void setTelmobile(String telmobile) {
        this.telmobile = telmobile;
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
     * Constructeur de l'objet Coordonnées
     * @param adresse
     * @param codePostal
     * @param ville
     * @param teldom
     * @param telmobile
     * @param email
     * @param matricule 
     */
    public Coordonnees(String adresse, int codePostal, String ville, String teldom, String telmobile, String email, int matricule) {
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.teldom = teldom;
        this.telmobile = telmobile;
        this.email = email;
        this.matricule = matricule;
    }
    
    
}
