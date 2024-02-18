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
import model.Category;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;
public class CategoryDao {
    public static void save(Category category){
        String query="insert into category(name)values('"+category.getName()+"')";
       DbOperations.setDataOrDelete(query, "Category added successfully");
    }
    //as the ManageCategory page loads all the rows in the category table will be appear in the table of the page..
    public static ArrayList<Category> getAllRecords(){
        ArrayList<Category> arraylist=new ArrayList<>();
        try{
            ResultSet rs=DbOperations.getData("select * from category");
            while(rs.next()){
                Category category=new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                arraylist.add(category);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylist;
    }
    public static void delete(String id){
        String query="delete from category where id='"+id+"'";
        DbOperations.setDataOrDelete(query, "Category deleted successfully");
    }
}
