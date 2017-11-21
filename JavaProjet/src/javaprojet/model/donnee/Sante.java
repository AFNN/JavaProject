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
public class Sante {
    private int matricule;
    private String medecinTraitant;
    private int telMedecin;
    private String vaccinations;
    private String allergies;
    private String remarquesMedicales;
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
     * 
     * @return medecinTraitant
     */
    public String getMedecinTraitant() {
        return medecinTraitant;
    }
    /**
     * 
     * @param medecinTraitant 
     */
    public void setMedecinTraitant(String medecinTraitant) {
        this.medecinTraitant = medecinTraitant;
    }
    /**
     * 
     * @return telMedecin
     */
    public int getTelMedecin() {
        return telMedecin;
    }
    /**
     * 
     * @param telMedecin 
     */
    public void setTelMedecin(int telMedecin) {
        this.telMedecin = telMedecin;
    }
    /**
     * 
     * @return vaccinations
     */
    public String getVaccinations() {
        return vaccinations;
    }
    /**
     * 
     * @param vaccinations 
     */
    public void setVaccinations(String vaccinations) {
        this.vaccinations = vaccinations;
    }
    /**
     * 
     * @return allergies
     */
    public String getAllergies() {
        return allergies;
    }
    /**
     * 
     * @param allergies 
     */
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
    /**
     * 
     * @return remarquesMedicales
     */
    public String getRemarquesMedicales() {
        return remarquesMedicales;
    }
    /**
     * 
     * @param remarquesMedicales 
     */
    public void setRemarquesMedicales(String remarquesMedicales) {
        this.remarquesMedicales = remarquesMedicales;
    }
    /**
     * Constructeur de la classe Sante
     * @param matricule
     * @param medecinTraitant
     * @param telMedecin
     * @param vaccinations
     * @param allergies
     * @param remarquesMedicales 
     */
    public Sante(int matricule, String medecinTraitant, int telMedecin, String vaccinations, String allergies, String remarquesMedicales) {
        this.matricule = matricule;
        this.medecinTraitant = medecinTraitant;
        this.telMedecin = telMedecin;
        this.vaccinations = vaccinations;
        this.allergies = allergies;
        this.remarquesMedicales = remarquesMedicales;
    }
    
    
    
    
}

