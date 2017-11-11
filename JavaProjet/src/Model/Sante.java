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
public class Sante {
    private int matricule;
    private String medecinTraitant;
    private int telMedecin;
    private String vaccinations;
    private String allergies;
    private String remarquesMedicales;

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getMedecinTraitant() {
        return medecinTraitant;
    }

    public void setMedecinTraitant(String medecinTraitant) {
        this.medecinTraitant = medecinTraitant;
    }

    public int getTelMedecin() {
        return telMedecin;
    }

    public void setTelMedecin(int telMedecin) {
        this.telMedecin = telMedecin;
    }

    public String getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(String vaccinations) {
        this.vaccinations = vaccinations;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getRemarquesMedicales() {
        return remarquesMedicales;
    }

    public void setRemarquesMedicales(String remarquesMedicales) {
        this.remarquesMedicales = remarquesMedicales;
    }

    public Sante(int matricule, String medecinTraitant, int telMedecin, String vaccinations, String allergies, String remarquesMedicales) {
        this.matricule = matricule;
        this.medecinTraitant = medecinTraitant;
        this.telMedecin = telMedecin;
        this.vaccinations = vaccinations;
        this.allergies = allergies;
        this.remarquesMedicales = remarquesMedicales;
    }
    
    
    
    
}

