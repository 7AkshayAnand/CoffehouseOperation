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
import model.Product;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class ProductDao {
    

    public static void save(Product product) {
        String query = "insert into product(name,category,price)values('" + product.getName() + "','" + product.getCategory() + "','" + product.getPrice() + "')";
        DbOperations.setDataOrDelete(query, "product Added successfully");
    }

    public static ArrayList<Product> getAllRecords() {
        ArrayList<Product> arraylist = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from product");
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                arraylist.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylist;
    }

    public static void Update(Product product) {
        String query = "update product set name='" + product.getName() + "' ,category='" + product.getCategory() + "', price='" + product.getPrice() + "' where id='" + product.getId() + "'";
        DbOperations.setDataOrDelete(query, "Product updated successfully");
    }

    public static void Delete(String id) {
        String query = "delete from product where id='" + id + "'";
        DbOperations.setDataOrDelete(query, "Product deleted successfully");
    }

    public static ArrayList<Product> getAllRecordsByCategory(String category) {
        ArrayList<Product> arraylist = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from product where category='" + category + "'");
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                arraylist.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylist;
    }

    public static ArrayList<Product> filterProductbyName(String name, String category) {
        ArrayList<Product> arraylist = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from product where name like '%" + name + "%' and category='" + category + "' ");
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                arraylist.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylist;
    }
    public static Product getProductByName(String name){
        Product product=new Product();
        try{
            ResultSet rs=DbOperations.getData("select * from product where name ='"+name+"'");
            while(rs.next()){
               product.setName(rs.getString("name"));
                   product.setCategory(rs.getString("category"));
                   product.setPrice(rs.getString("price"));
            }
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }
}
