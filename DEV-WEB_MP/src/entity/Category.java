package entity;

public class Category {
    
    private int categoryID;
    private String categoryName;
    
    public Category() {
        categoryID = 0;
        categoryName = "Not Initialized";
    }
    
    public Category(String categoryName) {
        this.categoryID = 0;
        this.categoryName = categoryName;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }
    
    public String getCategoryName(){
        return categoryName;
    }
    
}
