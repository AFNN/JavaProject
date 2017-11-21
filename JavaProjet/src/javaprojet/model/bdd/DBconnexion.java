/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.model.bdd;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arnaud Fouillard 
 * @version 1.1
 */
public class DBconnexion {
        private static Connection conn = null;
        private static Statement stmt =null;
        private static ResultSet rs=null;

/**
 * Cette méthode permet de se connecter à la base de donnée <br>
 * Elle utilise le driver JDBC <br>
 * Elle retourne l'objet Connection <br>
 * @return getConn()
 *      retourne un objet Connection
 * @throws SQLException 
 *      Permet de ...
 * 
 */
public static Connection connexionDB() throws SQLException{
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaprojet" ,"root", ""); //objet de connection pour ce connecter a la base
                
            }
            catch(SQLException sqle){       
                 System.out.println("ERREUR FATALE!"+sqle.getMessage());
            }
            finally{
                
                System.out.println("Connexion ouverte");
            }
        
            return getConn();
}   
    /**
     * 
     * @return conn
     *      retourne un objet Connexion
     */
    public static Connection getConn() {
        return conn;
    }
    /**
     * 
     * @param conn 
     *      objet Connexion
     */
    public static void setConn(Connection conn) {
        DBconnexion.conn = conn;
    }
    /**
     * 
     * @return stmt
     *      retourne un objet Statement
     */
    public static Statement getStmt() {
        return stmt;
    }
    /**
     * 
     * @param stmt 
     *      objet Statement
     */
    public static void setStmt(Statement stmt) {
        DBconnexion.stmt = stmt;
    }
    /**
     * 
     * @return rs
     *      objet ResultSet
     */
    public static ResultSet getRs() {
        return rs;
    }
    /**
     * 
     * @param rs 
     *      objet ResultSet
     */
    public static void setRs(ResultSet rs) {
        DBconnexion.rs = rs;
    }
    

    public static void main(String[] args) throws SQLException {
        connexionDB();
       
    }
    
    
}