package dao;

import entity.Group;
import entity.Right;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RightDAO {
    private ArrayList<Right> result = new ArrayList();
    private Connection conn = null;
    
    public ArrayList<Right> getRightList(){
        Right right;
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
            
            conn.setAutoCommit(false);
            
            String query = "SELECT * FROM rights";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                right = new Right();
                right.setRightId(rs.getInt("rightId"));
                right.setRightName(rs.getString("rightName"));
                right.setRightDescription(rs.getString("rightDescription"));
                result.add(right);
            }
            rs.close();
            pstmt.close();
            conn.commit();
            conn.close();
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(RightDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(RightDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(RightDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    public void addRight(Right r){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
            
            String query = "INSERT INTO rights (rightName, rightDescription, active) VALUES (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, r.getRightName());
            pstmt.setString(2, r.getRightDescription());
            pstmt.setBoolean(3, r.isActive());
            int result = pstmt.executeUpdate();
             
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(RightDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(RightDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addRightToGroup(Right r, Group g){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
            
            String query = "INSERT INTO groupright (groupId, rightId, active) VALUES (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, g.getGroupId());
            pstmt.setInt(2, r.getRightId());
            pstmt.setBoolean(3, r.isActive());
            int result = pstmt.executeUpdate();
             
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(RightDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(RightDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void deactivateRight(Right r){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
            
            String query = "UPDATE rights set active = ? WHERE rightId = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, !(r.isActive()));
            pstmt.setInt(2, r.getRightId());
            int result = pstmt.executeUpdate();
            
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(RightDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(RightDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void deactivateGroupRight(Group g, Right r){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
            
            String query = "UPDATE groupright set active = ? WHERE rightId = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, !(g.isActive()));
            pstmt.setInt(2, r.getRightId());
            int result = pstmt.executeUpdate();
            
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(RightDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(RightDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
