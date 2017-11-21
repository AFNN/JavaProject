/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.controller;

import javaprojet.view.Accueil;
import javax.swing.JFrame;

/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class Run {
    public static void main(String[] args) {
		
        
        
        Accueil acc = new Accueil();
        Controller control = new Controller(acc);
        acc.setVisible(true);
        
    }
    
    
}
