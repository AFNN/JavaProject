/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import static controller.DBconnexion.connexionDB;
import java.sql.*;
import model.*;
/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class GestionClasse {
    
    
    
    
    public static void addClasse(Classe c)   {

		try {
			DBconnexion.connexionDB();
			Statement stmt =  DBconnexion.getConn().createStatement();
			String insert = "INSERT INTO classe (`idClasse`, `NomClasse`, `idMatiere1`, `idMatiere2`, `idMatiere3`, `idMatiere4`)VALUES (NULL, '" + c.getNomClasse()+ "','" + c.getIdMatiere1() + "','"+ c.getIdMatiere2() + "','"+ c.getIdMatiere3() + "','"+ c.getIdMatiere4() + "')";
			stmt.executeUpdate(insert);
			System.out.println("Classe ajoute à la base de donnée");
		} catch (SQLException SQLe) {
			System.out.println("Echec de l'insertion dans la base : "+SQLe.getMessage());
		}
}
    public static void updateClasse(Classe c){
            try {
			DBconnexion.connexionDB();
			Statement stmt = DBconnexion.getConn().createStatement();
			String update = "UPDATE `classe` SET `NomClasse` = '" + c.getNomClasse() + "',`idMatiere1` = '" + c.getIdMatiere1() + "', `idMatiere2` = '" + c.getIdMatiere2() + "', `idMatiere3` = '" + c.getIdMatiere3() + "', `idMatiere4` = '" + c.getIdMatiere4() + "' WHERE `classe`.`idClasse` ='" + c.getIdClasse() + "' ;";
			stmt.executeUpdate(update);
			
			System.out.println("Classe modifie ");
		} catch (SQLException SQLe) {
			System.out.println("Echec de la mise à jour dans la base : "+SQLe.getMessage());
		}
        
        
        
        
    }
    
     public static void main(String[] args) throws SQLException {
        Classe c= new model.Classe(5, "ClasseTest2", 1, 2, 3, 4);
         
         updateClasse(c);
       
    }
    
    
    
}
