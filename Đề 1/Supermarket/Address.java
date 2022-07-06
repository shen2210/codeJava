package Supermarket;

import java.util.Scanner;

class Address {

    private int to;
    private int phuong;
    private String district;
    private String city;

    public Address(int to, int phuong, String district, String city) {
        this.to = to;
        this.phuong = phuong;
        this.district = district;
        this.city = city;
    }

    public Address() {
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getPhuong() {
        return phuong;
    }

    public void setPhuong(int phuong) {
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

    // nhap thong tin dia chi cua khach hang
    public void inputAddress(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Dia chi to : ");
        this.setTo(sc.nextInt());
        
        System.out.println("Dia chi phuong : ");
        this.setPhuong(sc.nextInt());
        sc.nextLine();
        
        System.out.println("Dia chi quan : ");
        this.setDistrict(sc.nextLine());
        
        System.out.println("Dia chi thanh pho : ");
        this.setCity(sc.nextLine());
    } 
}
