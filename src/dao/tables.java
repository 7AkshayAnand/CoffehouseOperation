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
import javax.swing.JOptionPane;
public class tables {
    public static void main(String[] args) {
        try {
            String userTable = "create table user(id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),mobileNumber varchar(10),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20),UNIQUE(email))";
            String adminDetails = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('Admin','admin@gmail.com','9801455148','PurneaBihar','admin','What primary school did you attend?','ABC','true')";
            String categoryTable = "create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
            String productTable="create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200))";
             String billTable = "create table bill(id int primary key,name varchar(200),mobileNumber varchar(200),email varchar(200),date varchar(50),total varchar(200),createdBy varchar(200))";
//            DbOperations.setDataOrDelete(userTable, "user Table created successfully");
//            DbOperations.setDataOrDelete(adminDetails, "Admin data inserted successfully");
//            DbOperations.setDataOrDelete(categoryTable, "categoryTable created  successfully");
//         DbOperations.setDataOrDelete(productTable, "product Table created successfully");
//             DbOperations.setDataOrDelete(billTable, "bill Table created successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
