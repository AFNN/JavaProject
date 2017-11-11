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
public class Identite {
   
    private String DateNaissance; 	
    private String VilleNaissance ;	
    private String PaysNaissance ;	
    private Boolean Sexe ;			
    private String DateInscription; 
    private String Etablissementpr ;
    private String Matricule; 	

    public String getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(String DateNaissance) {
        this.DateNaissance = DateNaissance;
    }

    public String getVilleNaissance() {
        return VilleNaissance;
    }

    public void setVilleNaissance(String VilleNaissance) {
        this.VilleNaissance = VilleNaissance;
    }

    public String getPaysNaissance() {
        return PaysNaissance;
    }

    public void setPaysNaissance(String PaysNaissance) {
        this.PaysNaissance = PaysNaissance;
    }

    public Boolean getSexe() {
        return Sexe;
    }

    public void setSexe(Boolean Sexe) {
        this.Sexe = Sexe;
    }

    public String getDateInscription() {
        return DateInscription;
    }

    public void setDateInscription(String DateInscription) {
        this.DateInscription = DateInscription;
    }

    public String getEtablissementpr() {
        return Etablissementpr;
    }

    public void setEtablissementpr(String Etablissementpr) {
        this.Etablissementpr = Etablissementpr;
    }

    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String Matricule) {
        this.Matricule = Matricule;
    }

    public Identite(String DateNaissance, String VilleNaissance, String PaysNaissance, Boolean Sexe, String DateInscription, String Etablissementpr, String Matricule) {
        this.DateNaissance = DateNaissance;
        this.VilleNaissance = VilleNaissance;
        this.PaysNaissance = PaysNaissance;
        this.Sexe = Sexe;
        this.DateInscription = DateInscription;
        this.Etablissementpr = Etablissementpr;
        this.Matricule = Matricule;
    }

    
    
}
