package entity;

public class Category {
    
    private int categoryID;
    private String categoryName;
    private String categoryDescription;
    
    public Category() {
        this.categoryID = 0;
        this.categoryName = "Not Initialized";
        this.categoryDescription = "Not Initialized";
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

    /**
     * @return the categoryDescription
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * @param categoryDescription the categoryDescription to set
     */
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
    
}
