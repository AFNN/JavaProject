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
public class Classe {
   private int idClasse ;
   private String NomClasse; 
   private int idMatiere1;
   private int idMatiere2;
   private int idMatiere3;
   private int idMatiere4;

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomClasse() {
        return NomClasse;
    }

    public void setNomClasse(String NomClasse) {
        this.NomClasse = NomClasse;
    }

    public int getIdMatiere1() {
        return idMatiere1;
    }

    public void setIdMatiere1(int idMatiere1) {
        this.idMatiere1 = idMatiere1;
    }

    public int getIdMatiere2() {
        return idMatiere2;
    }

    public void setIdMatiere2(int idMatiere2) {
        this.idMatiere2 = idMatiere2;
    }

    public int getIdMatiere3() {
        return idMatiere3;
    }

    public void setIdMatiere3(int idMatiere3) {
        this.idMatiere3 = idMatiere3;
    }

    public int getIdMatiere4() {
        return idMatiere4;
    }

    public void setIdMatiere4(int idMatiere4) {
        this.idMatiere4 = idMatiere4;
    }

    public Classe(int idClasse, String NomClasse, int idMatiere1, int idMatiere2, int idMatiere3, int idMatiere4) {
        this.idClasse = idClasse;
        this.NomClasse = NomClasse;
        this.idMatiere1 = idMatiere1;
        this.idMatiere2 = idMatiere2;
        this.idMatiere3 = idMatiere3;
        this.idMatiere4 = idMatiere4;
    }

    
    
}
