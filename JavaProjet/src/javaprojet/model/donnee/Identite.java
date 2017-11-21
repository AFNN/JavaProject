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
public class Identite {
   
    private String DateNaissance; 	
    private String VilleNaissance ;	
    private String PaysNaissance ;	
    private String Sexe ;			
    private String DateInscription; 
    private String Etablissementpr ;
    private String Matricule; 	
    /**
     * 
     * @return DateNaissance
     */
    public String getDateNaissance() {
        return DateNaissance;
    }
    /**
     * 
     * @param DateNaissance 
     */
    public void setDateNaissance(String DateNaissance) {
        this.DateNaissance = DateNaissance;
    }
    /**
     * 
     * @return VilleNaissance
     */
    public String getVilleNaissance() {
        return VilleNaissance;
    }
    /**
     * 
     * @param VilleNaissance 
     */
    public void setVilleNaissance(String VilleNaissance) {
        this.VilleNaissance = VilleNaissance;
    }
    /**
     * 
     * @return PaysNaissance
     */
    public String getPaysNaissance() {
        return PaysNaissance;
    }
    /**
     * 
     * @param PaysNaissance 
     */
    public void setPaysNaissance(String PaysNaissance) {
        this.PaysNaissance = PaysNaissance;
    }
    /** 
     * 
     * @return Sexe
     */
    public String getSexe() {
        return Sexe;
    }
    /**
     * 
     * @param Sexe 
     */
    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }
    /**
     * 
     * @return DateInscription
     */
    public String getDateInscription() {
        return DateInscription;
    }
    /**
     * 
     * @param DateInscription 
     */
    public void setDateInscription(String DateInscription) {
        this.DateInscription = DateInscription;
    }
    /**
     * 
     * @return Etablissementpr
     */
    public String getEtablissementpr() {
        return Etablissementpr;
    }
    /**
     * 
     * @param Etablissementpr 
     */
    public void setEtablissementpr(String Etablissementpr) {
        this.Etablissementpr = Etablissementpr;
    }
    /**
     * 
     * @return Matricule
     */
    public String getMatricule() {
        return Matricule;
    }
    /**
     * 
     * @param Matricule 
     */
    public void setMatricule(String Matricule) {
        this.Matricule = Matricule;
    }
    /**
     * Constructeur de la classe Identite
     * @param DateNaissance
     * @param VilleNaissance
     * @param PaysNaissance
     * @param Sexe
     * @param DateInscription
     * @param Etablissementpr
     * @param Matricule 
     */
    public Identite(String DateNaissance, String VilleNaissance, String PaysNaissance, String Sexe, String DateInscription, String Etablissementpr, String Matricule) {
        this.DateNaissance = DateNaissance;
        this.VilleNaissance = VilleNaissance;
        this.PaysNaissance = PaysNaissance;
        this.Sexe = Sexe;
        this.DateInscription = DateInscription;
        this.Etablissementpr = Etablissementpr;
        this.Matricule = Matricule;
    }

    
    
}
