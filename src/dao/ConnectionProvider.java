/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author DELL
 */
import java.sql.*;

public class ConnectionProvider {

    

    public static Connection getCon() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Coffee", "root", "akshay");

            return con;

        } catch (Exception e) {
            
            return null;
        }
    }
}
