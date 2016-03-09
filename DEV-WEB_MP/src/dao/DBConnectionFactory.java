package dao;

import java.sql.Connection;

/* tried and tested  3/1/2016 */
public abstract class DBConnectionFactory {

    private String driverName = "com.mysql.jdbc.Driver";
    private String url= "jdbc:mysql://localhost:3306/dev-web";
    private String username = "kimson_trading";
    private String password = "devwebS15";
    private Connection con;

    public static DBConnectionFactory getInstance() {
        return new DBConnectionFactoryImpl();
    }
    
    protected String getDriverName(){
        return driverName;
    }
    
    protected String getUrl(){
        return url;
    }
    
    protected String getUsername(){
        return username;
    }
    
    protected String getPassword(){
        return password;
    }

    protected Connection getConnection(){
        return con;
    }
}
