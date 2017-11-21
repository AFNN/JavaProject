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
public class Classe {
   private int idClasse ;
   private String nomClasse; 
   private int idMatiere1;
   private int idMatiere2;
   private int idMatiere3;
   private int idMatiere4;
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
     * 
     * @return nomClasse
     */
    public String getNomClasse() {
        return nomClasse;
    }
    /**
     * 
     * @param nomClasse 
     */
    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }
    /**
     * 
     * @return idMatiere1
     */
    public int getIdMatiere1() {
        return idMatiere1;
    }
    /**
     * 
     * @param idMatiere1 
     */
    public void setIdMatiere1(int idMatiere1) {
        this.idMatiere1 = idMatiere1;
    }
    /**
     * 
     * @return idMatiere2
     */
    public int getIdMatiere2() {
        return idMatiere2;
    }
    /**
     * 
     * @param idMatiere2 
     */
    public void setIdMatiere2(int idMatiere2) {
        this.idMatiere2 = idMatiere2;
    }
    /**
     * 
     * @return idMatiere3
     */
    public int getIdMatiere3() {
        return idMatiere3;
    }
    /**
     * 
     * @param idMatiere3 
     */
    public void setIdMatiere3(int idMatiere3) {
        this.idMatiere3 = idMatiere3;
    }
    /**
     * 
     * @return idMatiere4
     */
    public int getIdMatiere4() {
        return idMatiere4;
    }
    /**
     * 
     * @param idMatiere4 
     */
    public void setIdMatiere4(int idMatiere4) {
        this.idMatiere4 = idMatiere4;
    }
    /**
     * Constructeur de l'objet Classe
     * @param idClasse
     * @param NomClasse
     * @param idMatiere1
     * @param idMatiere2
     * @param idMatiere3
     * @param idMatiere4 
     */
    
    public Classe(int idClasse, String NomClasse, int idMatiere1, int idMatiere2, int idMatiere3, int idMatiere4) {
        this.idClasse = idClasse;
        this.nomClasse = NomClasse;
        this.idMatiere1 = idMatiere1;
        this.idMatiere2 = idMatiere2;
        this.idMatiere3 = idMatiere3;
        this.idMatiere4 = idMatiere4;
    }

    
    
}
