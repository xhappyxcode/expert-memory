package dao;

import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO {

    //return all
   
    public ArrayList<Product> getCategoryList(){
        ArrayList<Product> result = new ArrayList<Product>(0);
        Connection conn = null;
        try {
            
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
        
            conn.setAutoCommit(false);
            /* get list of products from product table */
            String query = "SELECT * FROM product WHERE active = 1";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setProductID(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductDescription(rs.getString("description"));
                product.setUnit(rs.getString("unit"));
            }
            /* get the categories from category table */
            query = "SELECT categoryName FROM category c, productCategory pc "
                    + "WHERE c.categoryId = pc.categoryId AND pc.productId = ?";
            pstmt = conn.prepareStatement(query);
            for(int i = 0; i < result.size(); i++) {
                pstmt.setInt(1, result.get(i).getProductID());
                rs = pstmt.executeQuery();
                while(rs.next()) {
                    result.get(i).addProductCategory(rs.getString("categoryName"));
                }
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    //return filter category and keyword, if category is null do not search and vice versa
    public ArrayList<Product> getCategoryList(String keyword, String category){
        ArrayList<Product> result = new ArrayList<Product>(0);
        Connection conn = null;
        try {
            
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
        
            conn.setAutoCommit(false);
            /* get list of products from product table */
            String query = "SELECT * FROM product WHERE active = 1";
            if(keyword != null) {
                query += " AND productName LIKE "+ keyword;
            }
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setProductID(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductDescription(rs.getString("description"));
                product.setUnit(rs.getString("unit"));
            }
            /* get the categories from category table */
            query = "SELECT categoryName FROM category c, productCategory pc "
                    + "WHERE c.categoryId = pc.categoryId AND pc.productId = ?";
            pstmt = conn.prepareStatement(query);
            for(int i = 0; i < result.size(); i++) {
                pstmt.setInt(1, result.get(i).getProductID());
                rs = pstmt.executeQuery();
                while(rs.next()) {
                    result.get(i).addProductCategory(rs.getString("categoryName"));
                }
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
