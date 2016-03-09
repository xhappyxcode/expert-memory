package dao;

import dev.web_mp.DEVWEB_MP;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/* tried and tested  3/1/2016 */
public class DBConnectionFactoryImpl extends DBConnectionFactory{
    public Connection getConnection(){
        try {
            Class.forName(getDriverName());
            Connection con = DriverManager.getConnection(
                    getUrl(), getUsername(), getPassword());
            System.out.println("Connected");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(DEVWEB_MP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnectionFactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
