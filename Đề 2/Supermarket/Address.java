package Supermarket;

import java.util.Scanner;

class Address {

    private Integer to;
    private Integer phuong;
    private String district;
    private String city;

    public Address(Integer to, Integer phuong, String district, String city) {
        this.to = to;
        this.phuong = phuong;
        this.district = district;
        this.city = city;
    }

    public Address() {
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getPhuong() {
        return phuong;
    }

    public void setPhuong(Integer phuong) {
        this.phuong = phuong;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" + "to=" + to + ", phuong=" + phuong + ", district=" + district + ", city=" + city + '}';
    }

    
    public void inputAddress() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap dia chi to : ");
        this.setTo(sc.nextInt());
        System.out.println("Nhap dia chi phuong : ");
        this.setPhuong(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhap dia chi quan : ");
        this.setDistrict(sc.nextLine());
        System.out.println("Nhap dia chi thanh pho : ");
        this.setCity(sc.nextLine());
    }
}
