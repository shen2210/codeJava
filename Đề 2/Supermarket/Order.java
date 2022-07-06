package Supermarket;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String id;
    private String customerName;
    private Integer birthYear;
    private Address address;
    private double totalPrice;

    private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

    public Order(String id, String customerName, Integer birthYear, Address address) {
        this.id = id;
        this.customerName = customerName;
        this.birthYear = birthYear;
        this.address = address;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerName=" + customerName + ", birthYear=" + birthYear + ", address=" + address + '}';
    }

}
