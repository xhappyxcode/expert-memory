package entity;

public class User {
    
    private int userid, groupid;
    private String username, password;
    
    public User() {
        this.username = "Not Instantiated";
        this.password = "Not instantiated";
    }
    
    public User(int id, String username, String password, int group) {
        this.userid = id;
        this.username = username;
        this.password = password;
        this.groupid = groupid;
    }
    
    public User(String username, String password, int group) {
        this.username = username;
        this.password = password;
        this.groupid = groupid;
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String toString() {
        return username +"\t"+password+"\t"+groupid;
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
    public int getGroupId() {
        return groupid;
    }

    /**
     * @param group the group to set
     */
    public void setGroupId(int group) {
        this.groupid = group;
    }
    
    
}
