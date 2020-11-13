/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author Mohit
 */
public class Database {
   
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    public static Connection connectDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:Accdetails.db";
            Connection conn = DriverManager.getConnection(url);
            System.out.println("connected");
            return conn;
        }catch(Exception e){
           System.out.println("not connn");
            return null;
        }
       
    }
    
}
