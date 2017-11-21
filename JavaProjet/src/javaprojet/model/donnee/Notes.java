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
public class Notes {

    private double  moyenne;
    private int matricule;  
    private int idMatière; 
    /**
     * 
     * @return moyenne
     */
    public double getMoyenne() {
        return moyenne;
    }
    /**
     * 
     * @param moyenne 
     */
    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
    /**
     * 
     * @return Matricule
     */
    public int getMatricule() {
        return matricule;
    }
    /**
     * 
     * @param Matricule 
     */
    public void setMatricule(int Matricule) {
        this.matricule = Matricule;
    }
    /**
     * 
     * @return idMatière
     */
    public int getIdMatière() {
        return idMatière;
    }
    /**
     * 
     * @param idMatière 
     */
    public void setIdMatière(int idMatière) {
        this.idMatière = idMatière;
    }
    /**
     * Constructeur de la classe note
     * @param moyenne
     * @param Matricule
     * @param idMatière 
     */
    public Notes(double moyenne, int Matricule, int idMatière) {
        this.moyenne = moyenne;
        this.matricule = Matricule;
        this.idMatière = idMatière;
    }
    
}
