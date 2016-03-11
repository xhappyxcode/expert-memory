package entity;

import java.util.ArrayList;

public class Product {
    
    private int productID;
    private String productName, productDescription;
    private ArrayList<String> productCategory; 
    private String unit;
    private boolean active;
    
    public Product() {
        
    }
    
    public Product(int id, String name, String description, String unit, boolean active) {
        this.productID = id;
        this.productName = name;
        this.productDescription = description;
        this.unit = unit;
        this.active = active;
    }
    
    public Product(String name, String description, ArrayList<String> category, String unit, boolean active) {
        this.productName = name;
        this.productDescription = description;
        this.productCategory = category;
        this.unit = unit;
        this.active = active;
    }
    
    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    public int getProductID() {
        return productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    /**
     * @return the productCategory
     */
    public ArrayList<String> getProductCategory() {
        return productCategory;
    }

    /**
     * @param productCategory the productCategory to set
     */
    public void setProductCategory(ArrayList<String> productCategory) {
        this.productCategory = productCategory;
    }
    
    public void addProductCategory(String category) {
        productCategory.add(category);
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * @param productDescription the productDescription to set
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

}
