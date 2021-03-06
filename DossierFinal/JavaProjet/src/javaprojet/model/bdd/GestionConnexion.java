/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.model.bdd;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Arnaud Fouillard 
 */
public class GestionConnexion {
    
    /**
     * Cette méthode permet de vérifier que l'utilisateur possède les droits pour se connecter
     * @param login
     * @param mdp
     * @return connection
     * @throws SQLException 
     */
    public static boolean  userConnection(String login,String mdp) throws SQLException{
        ResultSet resmdp=null,res=null;
        Statement stmt=null;
        String mdpBDD="";
        boolean connection=false;  
        
        try {
            javaprojet.model.bdd.DBconnexion.connexionDB();
            stmt= DBconnexion.getConn().createStatement();
            String userLogin="SELECT LOGIN From userapplication WHERE LOGIN='"+login+"'";
            System.out.println("DEBUG / USERLOGIN REQUEST"+userLogin);
            res=stmt.executeQuery(userLogin);
            
            
        } catch (SQLException SQLe) {
            System.out.println("Probleme lors de la recherche dans la BDD "+SQLe.getMessage());
            JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, SQLe.getMessage(), "Erreur BDD", JOptionPane.ERROR_MESSAGE);            
        } 
        
        if(res.first())
        {
            System.out.println("L'utilisateur a été trouvé dans la base de donnée ");
            try {
                    String MDPuser="SELECT PASSWORD FROM userapplication WHERE LOGIN='"+login+"'";
                    System.out.println("DEBUG / MDPUSER REQUEST"+MDPuser);
                    resmdp=stmt.executeQuery(MDPuser);
                    
                    
            } catch (SQLException SQLmdpE) {
                   System.out.println("Probleme lors de la recherche dans la BDD "+SQLmdpE.getMessage());
                   JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, SQLmdpE.getMessage(), "Erreur BDD", JOptionPane.ERROR_MESSAGE);
                   
            }
            
            if(resmdp.first())
                {
                        System.out.println("Password de l'utilisateur trouvé");
                        //defini le mdp dans une variable locale pour pouvoir comparer par la suite
                        mdpBDD=resmdp.getString("PASSWORD");
                        if(mdp.equals(mdpBDD)==true){
                            connection=true;
                            System.out.println("DEBUG / MDPUSER = "+mdpBDD);
                            System.out.println("Utilisateur connecté");
                        } 
                        
                }
        }
    stmt.close();
    return connection;         
    }
    

    /**
     * Cette méthode permet de vériier si l'utilisateur est admin
     * @param login
     * @return admin
     * @throws SQLException 
     */
    
    public static boolean CheckAdmin(String login) throws SQLException{
           boolean admin=false;
           ResultSet res=null;
           String adminres="";
           Statement stmt=null;
           try {
            javaprojet.model.bdd.DBconnexion.connexionDB();
            stmt= DBconnexion.getConn().createStatement();
            String userLogin="SELECT ADMIN From userapplication WHERE LOGIN='"+login+"'";
            res=stmt.executeQuery(userLogin);
            admin=res.first();
            if(adminres=="1"){
                admin=true;
            }
        } catch (SQLException SQLe) {
            System.out.println("Probleme lors de la recherche dans la BDD "+SQLe.getMessage());
            stmt.close();
            JOptionPane jop1 = new JOptionPane();
            jop1.showMessageDialog(null, SQLe.getMessage(), "Erreur BDD", JOptionPane.ERROR_MESSAGE);            
        }
        return admin;
    }
     
}
