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
            
            String query = "SELECT * FROM category";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                cat = new Category();
                cat.setCategoryID(rs.getInt("categoryID"));
                cat.setCategoryName(rs.getString("categoryName"));
                result.add(cat);
            }
            rs.close();
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
        return result;
    }
    
    public void addCategory(Category c){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
            
            String query = "INSERT INTO category (categoryName) VALUES (?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, c.getCategoryName());
            int result = pstmt.executeUpdate();
            
            if(result == 1)
                System.out.println("Category was added");
            
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
