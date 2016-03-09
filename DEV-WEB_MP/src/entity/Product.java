package entity;

public class Product {
    
    private int productID;
    private String productName, productStatus;
    private String productCategory1, productCategory2, productCategory3;
    private String unit;

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
    
    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductCategory1(String productCategory1) {
        this.productCategory1 = productCategory1;
    }
    
    public String getProductCategory1() {
        return productCategory1;
    }

    public void setProductCategory2(String productCategory2) {
        this.productCategory2 = productCategory2;
    }
    
    public String getProductCategory2() {
        return productCategory2;
    }

    public void setProductCategory3(String productCategory3) {
        this.productCategory3 = productCategory3;
    }

    public String getProductCategory3() {
        return productCategory3;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

}
