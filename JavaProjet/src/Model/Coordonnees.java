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
public class Coordonnees {
    private String adresse ;
    private int codePostal;
    private String ville ;
    private int teldom ;
    private int telmobile; 
    private String email ;
    private int matricule;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getTeldom() {
        return teldom;
    }

    public void setTeldom(int teldom) {
        this.teldom = teldom;
    }

    public int getTelmobile() {
        return telmobile;
    }

    public void setTelmobile(int telmobile) {
        this.telmobile = telmobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public Coordonnees(String adresse, int codePostal, String ville, int teldom, int telmobile, String email, int matricule) {
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.teldom = teldom;
        this.telmobile = telmobile;
        this.email = email;
        this.matricule = matricule;
    }
    
    
}
