package Supermarket;

public class Product {

    private String id;
    private String nameProduct;
    private String productionDate;
    private double price;
    private Integer quantity;

    public Product(String id, String nameProduct, String productionDate, double price, Integer quantity) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.productionDate = productionDate;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", nameProduct=" + nameProduct + ", productionDate=" + productionDate + ", price=" + price + ", quantity=" + quantity + '}';
    }
    
    


}
