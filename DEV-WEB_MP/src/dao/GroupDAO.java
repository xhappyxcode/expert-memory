package dao;

import entity.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GroupDAO {
    public void addGroup(Group g){
        Connection conn = null;
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
            
            String query = "INSERT INTO groups(name, description, active) VALUES (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, g.getGroupName());
            pstmt.setString(2, g.getGroupDescription());
            pstmt.setBoolean(3, g.isActive());
            int result = pstmt.executeUpdate();
             
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void deactivateGroup(Group g){
        Connection conn = null;
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
            
            String query = "UPDATE groups set active = ? where groupId = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, !(g.isActive()));
            pstmt.setInt(2, g.getGroupId());
            int result = pstmt.executeUpdate();
            
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
