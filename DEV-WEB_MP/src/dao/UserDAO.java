package dao;

import dev.web_mp.DEVWEB_MP;
import entity.Group;
import entity.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/* tried and tested  3/1/2016 */
public class UserDAO {
    
    private Connection conn;
    
    public Group SignUp(User user) {
        Group group = new Group();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
            
            conn.setAutoCommit(false);
            
            String query = "INSERT INTO user (username, password) VALUES (?, ?)";
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            int result = pstmt.executeUpdate();
            
            query = "SELECT userId FROM user WHERE username = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getUsername());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                user.setUserid(rs.getInt("userId"));
            }
            
            query = "INSERT INTO usergroup(userId, groupId, active) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, user.getUserid());
            pstmt.setInt(2, user.getGroupId());
            pstmt.setBoolean(3, true);
            int result2 = pstmt.executeUpdate();
            
            query = "SELECT rights.rightName FROM rights "
                    + "WHERE rights.rightId IN "
                    + "(SELECT groupright.rightId "
                    + "FROM groupright "
                    + "WHERE groupright.groupId = ? "
                    + "AND groupright.active = 1) AND rights.active = 1";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, user.getGroupId());
            rs = pstmt.executeQuery();
            ArrayList<String> rights = new ArrayList<String>(); //<-----THIS
            while(rs.next()){
                rights.add(rs.getString("rightName"));
            }
            group.setRights(rights);
            
            pstmt.close();
            
//            if(result == 1){
//                System.out.println("Your account has been added!");
//            } else {
//                System.out.println("Your account has failed to be added!");
//            }
            
            conn.commit();
            conn.close();
            
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return group;
   }
   
   public boolean SignIn(User user) {
       boolean success = false;
       try{
           DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
           conn = myFactory.getConnection();
           
           conn.setAutoCommit(false);

           String query = "select * from user where username = ? and password = ?";
           PreparedStatement pstmt = conn.prepareStatement(query);
           pstmt.setString(1, user.getUsername());
           pstmt.setString(2, user.getPassword());

           ResultSet rs = pstmt.executeQuery();

           if(rs.next()){
//               System.out.println("Sign in successful!");
               success = true;
           } 
//           else{
//               System.out.println("Sign in not successful!");
//           }

           rs.close();
           pstmt.close();
           conn.commit();
           conn.close();
           
       }catch(SQLException ex){
           try {
               conn.rollback();
           } catch (SQLException ex1) {
               Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
           }
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

