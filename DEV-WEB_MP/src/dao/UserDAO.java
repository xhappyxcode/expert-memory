package dao;

import dev.web_mp.DEVWEB_MP;
import entity.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/* tried and tested  3/1/2016 */
public class UserDAO {
    
    private Connection conn;
    
    public void SignUp(User user) {
        
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
            
            String query = "INSERT INTO user (username, password) VALUES (?, ?)";
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            int result = pstmt.executeUpdate();
            
            pstmt.close();
            
            if(result == 1){
                System.out.println("Your account has been added!");
            } else {
                System.out.println("Your account has failed to be added!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   }
   
   public boolean SignIn(User user) {
       boolean success = false;
       try{
           DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
           conn = myFactory.getConnection();

           String query = "select * from user where username = ? and password = ?";
           PreparedStatement pstmt = conn.prepareStatement(query);
           pstmt.setString(1, user.getUsername());
           pstmt.setString(2, user.getPassword());

           ResultSet rs = pstmt.executeQuery();

           if(rs.next()){
               System.out.println("Sign in successful!");
               success = true;
           } else{
               System.out.println("Sign in not successful!");
           }

           rs.close();
           pstmt.close();
 
       }catch(SQLException ex){
           java.util.logging.Logger.getLogger(DEVWEB_MP.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       return success;
   }
}

