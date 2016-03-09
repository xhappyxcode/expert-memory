package entity;

public class User {
    
    private String username, password;
    
    public User() {
        this.username = "Not Instantiated";
        this.password = "Not instantiated";
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
}
