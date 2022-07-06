package Supermarket;

public class Product {

    private String id;
    private String productName;
    private String productionDate;
    private double price;
    private Integer quantity;

    public Product() {
    }

    public Product(String id, String productName, String productionDate, double price, Integer quantity) {
        this.id = id;
        this.productName = productName;
        this.productionDate = productionDate;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", productName=" + productName + ", productionDate=" + productionDate + ", price=" + price + ", quantity=" + quantity + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

   
    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
}
