package entity;

public class User {
    
    private int userid;
    private String username, password, group;
    /* add group */
    public User() {
        this.username = "Not Instantiated";
        this.password = "Not instantiated";
    }
    
    public User(int id, String username, String password, String group) {
        this.userid = id;
        this.username = username;
        this.password = password;
        this.group = group;
    }
    
    public User(String username, String password, String group) {
        this.username = username;
        this.password = password;
        this.group = group;
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

    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(String group) {
        this.group = group;
    }
    
}
