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
     *  int matricule etudiant
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
     *      String Nom etudiant 
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
     * @param Prenom 
     *  String prenom etudiant
     */
    public void setPrenom(String Prenom) {
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
     *      int IDCLASSE etudiant
     */
    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }
    /**
     * Constructeur de l'objet Etudiant
     * @param Matricule
     *      int matricule etudiant
     * @param Nom
     *      String nom etudiant
     * @param Prenom
     *      String prenom etudiant
     * 
     * @param idClasse 
     *      int idClasse etudiant 
     */
    public Etudiant(int Matricule, String Nom, String Prenom, int idClasse) {
        this.Matricule = Matricule;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.idClasse = idClasse;
    }
    
    
    
}
