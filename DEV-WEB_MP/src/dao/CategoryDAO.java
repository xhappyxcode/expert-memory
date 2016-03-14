package dao;

import entity.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/* tried and tested  3/1/2016 */
public class CategoryDAO {
    
    private ArrayList<Category> result = new ArrayList();
    private Connection conn = null;
    
    public ArrayList<Category> getCategoryList(){
        Category cat;
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
            
            conn.setAutoCommit(false);
            
            String query = "SELECT * FROM category";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                cat = new Category();
                cat.setCategoryID(rs.getInt("categoryID"));
                cat.setCategoryName(rs.getString("categoryName"));
                cat.setCategoryDescription(rs.getString("description"));
                result.add(cat);
            }
            rs.close();
            pstmt.close();
            conn.commit();
            conn.close();
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
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
    
    public void addCategory(Category c){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
            
            String query = "INSERT INTO category (categoryName, categoryDescription) VALUES (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, c.getCategoryName());
            pstmt.setString(2, c.getCategoryDescription());
            int result = pstmt.executeUpdate();
            
//            if(result == 1)
//                System.out.println("Category was added");
            
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
