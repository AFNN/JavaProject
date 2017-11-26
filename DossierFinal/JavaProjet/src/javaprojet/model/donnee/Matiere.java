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
public class Matiere {
    private int idMatiere;
    private String nomMat;
    /**
     * 
     * @return idMatiere
     */
    public int getIdMatiere() {
        return idMatiere;
    }
    /**
     * 
     * @param idMatiere 
     */
    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }
    /**
     * 
     * @return nomMat
     */
    public String getNomMat() {
        return nomMat;
    }
    /**
     * 
     * @param nomMat 
     */
    public void setNomMat(String nomMat) {
        this.nomMat = nomMat;
    }
    /**
     * Constructeur de la classe matiere
     * @param idMatiere
     * @param nomMat 
     */
    public Matiere(int idMatiere, String nomMat) {
        this.idMatiere = idMatiere;
        this.nomMat = nomMat;
    }

    
    
    
    
}
