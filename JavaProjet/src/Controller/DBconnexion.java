/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arnaud Fouillard <Arnaud Fouillard@EFREI>
 */
public class DBconnexion {
        private static Connection conn = null;
        private static Statement stmt =null;
        private static ResultSet rs=null;


public static Connection connexionDB() throws SQLException{
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaprojet" ,"root", ""); //objet de connection pour ce connecter a la base
                /*stmt = conn.createStatement();
                rs =stmt.executeQuery("SELECT * FROM etudiant");
                while(rs.next()){
                    System.out.println("Matricule = "+rs.getString("MATRICULE"));
                    System.out.println("NOM = "+rs.getString("NOM"));
                    System.out.println("Prenom="+rs.getString("Prenom")+"\n");
                }*/
            }
            catch(SQLException sqle){       
                 System.out.println("ERREUR FATALE!"+sqle.getMessage());
            }
            finally{
                
                System.out.println("Connexion ouverte");
            }
        
            return getConn();
}   

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        DBconnexion.conn = conn;
    }

    public static Statement getStmt() {
        return stmt;
    }

    public static void setStmt(Statement stmt) {
        DBconnexion.stmt = stmt;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static void setRs(ResultSet rs) {
        DBconnexion.rs = rs;
    }
    /*
    public boolean userConnection() throws SQLException{
        ResultSet res=null;    
        
        try {
                connexionDB();
                stmt = (Statement) getConn().createStatement();
                String LoginUser = "SELECT Login from Personne where (Login =)";
                res = (ResultSet) stmt.executeQuery(LoginUser);
            } catch (SQLException ex) {
                Logger.getLogger(DBconnexion.class.getName()).log(Level.SEVERE, null, ex);
            }


if (res.first()) {

        System.out.println("Utilisateur trouve");
        String MDPUser = "SELECT MDP from Personne where (Login = )";
        ResultSet res2 = (ResultSet) stmt.executeQuery(MDPUser);
        if (res2.first()) {

                String mdp = res2.getString("MDP");
                System.out.println("Mot de passe trouve");
            
                if ((mdp=="root") == true) {

                        System.out.println("Utilisateur connecte");
                        String IDUser = "SELECT ID from Personne where (Login = ";
                                        
                        ResultSet res3 = (ResultSet) stmt.executeQuery(IDUser);
                        while (res3.next()) {

                                b = res3.getInt("ID");

                                System.out.println("ID : " + b)
                        }
    
    
    
      return userConnection;
    }*/
    
    
    
    
    public static void main(String[] args) throws SQLException {
        connexionDB();
       
    }
    
    
}