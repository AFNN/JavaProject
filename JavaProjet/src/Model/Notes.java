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
public class Notes {

    private double  moyenne;
    private int matricule;  
    private int idMatière; 

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int Matricule) {
        this.matricule = Matricule;
    }

    public int getIdMatière() {
        return idMatière;
    }

    public void setIdMatière(int idMatière) {
        this.idMatière = idMatière;
    }

    public Notes(double moyenne, int Matricule, int idMatière) {
        this.moyenne = moyenne;
        this.matricule = Matricule;
        this.idMatière = idMatière;
    }
    
}
