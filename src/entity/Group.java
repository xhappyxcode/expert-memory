package entity;

import java.util.ArrayList;

public class Group {
    
    private ArrayList<String> rights;
    private int groupId;
    private String groupName;
    private boolean active;
    
    public Group(){
        
    }
    
    public Group(int groupId, String groupName, boolean active){
        this.groupId = groupId;
        this.groupName = groupName;
        this.active = active;
    }
    
    public Group(int groupId, String groupName, boolean active, ArrayList<String> rights){
        this.groupId = groupId;
        this.groupName = groupName;
        this.active = active;
        this.rights = rights;
    }

    public ArrayList<String> getRights() {
        return rights;
    }

    public void setRights(ArrayList<String> rights) {
        this.rights = rights;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}
