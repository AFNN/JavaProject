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
public class Etudiant {
    
    private int Matricule;
    private String Nom;
    private String Prenom;
    private int idClasse;
    
    /**
     * 
     * @return Matricule
     */
    public int getMatricule() {
        return Matricule;
    }
    /**
     * 
     * @param Matricule 
     */
    public void setMatricule(int Matricule) {
        this.Matricule = Matricule;
    }
    /**
     * 
     * @return Nom 
     */
    public String getNom() {
        return Nom;
    }
    /**
     * 
     * @param Nom 
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }
    /**
     * 
     * @return Prenom
     */
    public String getPrenom() {
        return Prenom;
    }
    /**
     * 
     * @param Prénom 
     */
    public void setPrenom(String Prénom) {
        this.Prenom = Prenom;
    }
    /**
     * 
     * @return idClasse
     */
    public int getIdClasse() {
        return idClasse;
    }
    /**
     * 
     * @param idClasse 
     */
    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }
    /**
     * Constructeur de l'objet Etudiant
     * @param Matricule
     * @param Nom
     * @param Prenom
     * @param idClasse 
     */
    public Etudiant(int Matricule, String Nom, String Prenom, int idClasse) {
        this.Matricule = Matricule;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.idClasse = idClasse;
    }
    
    
    
}
