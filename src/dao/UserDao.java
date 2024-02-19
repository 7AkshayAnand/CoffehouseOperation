/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.swing.JOptionPane;
import model.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author DELL
 */
public class UserDao {

    //save method is reciving all the details of user table of model package like name email mobilenumber address etc...
    public static void save(User user) {
        String query = "insert into  user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('" + user.getName() + "','" + user.getEmail() + "','" + user.getMobileNumber() + "','" + user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" + user.getAnswer() + "','false')";
        DbOperations.setDataOrDelete(query, "Registered Successfully! wait for Admin Approval");
    }

    public static User login(String email, String password) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("select * from user where email ='" + email + "' and password='" + password + "'");
            while (rs.next()) {
                user = new User();
                //getString("") it is used to return the data of specified column index of the current row as String.

                user.setStatus(rs.getString("status"));
                //System.out.println("Status by rs.getString is  " + rs.getString("status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static User getSecurityQuestion(String email) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("select * from user  where email ='" + email + "'");
            while (rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static void Update(String email, String newPassword) {
        String query = "Update user set password='" + newPassword + "' where email='" + email + "'";
        DbOperations.setDataOrDelete(query, "password changed successfully");
    }

    public static ArrayList<User> getAllRecords(String email) {
        ArrayList<User> arraylist = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from user where email like '%" + email + "%'");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arraylist.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return arraylist;
    }

    public static void changeStatus(String email, String status) {
        String query = "update user set status='" + status + "' where email='" + email + "'";
        DbOperations.setDataOrDelete(query, "Status changed successfully");
    }

    public static void changePassword(String email, String oldPassword, String newPassword) {
        try {
            ResultSet rs = DbOperations.getData("select * from user where email='" + email + "' and password='" + oldPassword + "'");
            if (rs.next()) {
               Update(email,newPassword);
            } else {
                JOptionPane.showMessageDialog(null, "Old Password is wrong");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void changeSecurityQuestion(String email,String password,String securityQuestion,String answer){
        try{
            ResultSet rs=DbOperations.getData("select * from user where email='"+email+"' and password='"+password+"'");
            if(rs.next()){
                update(email,securityQuestion,answer);
            }else{
                JOptionPane.showMessageDialog(null, "Password is wrong!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public static void update(String email,String securityQuestion ,String answer){
        String query="update user set securityQuestion='"+securityQuestion+"' , answer='"+answer+"' where email='"+email+"'";
        DbOperations.setDataOrDelete(query, "Security Question changed successfully");
    }
}
