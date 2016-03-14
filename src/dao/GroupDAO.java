/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Group;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;

/**
 *
 * @author Joy
 */
public class GroupDAO {
    
    public ArrayList<String> getRights(User user) {
        ArrayList<String> rights = new ArrayList<String>(0);
        Connection conn = null;
        
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            conn = myFactory.getConnection();
            conn.setAutoCommit(false);
            
            String query = "SELECT rights.rightName FROM rights WHERE rights.rightId = "
                    + "(SELECT groupright.rightId FROM groupright, groups "
                    + "WHERE groupright.groupId = groups.groupId "
                    + "AND groupright.active = 1) AND rights.active = 1";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            Group group = new Group();
            while(rs.next()){
                rights.add(rs.getString("rightName"));
            }
            
            group.setRights(rights);
            
            rs.close();
            pstmt.close();
            conn.commit();
            conn.close();
            
            if(rights.size() > 0) {
                System.out.println("Successfully retrived user rights!");
            } else {
                System.out.println("Failed to retrieve user rights");
            }
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
        return rights;
    }
}
