package Supermarket;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductService {

    Scanner input = new Scanner(System.in);

    // Sieu thi them 1 san pham
    public void insert() {
        try {
            System.out.println("NHAP THONG TIN SAN PHAM");

            if (App.PRODUCTS.isEmpty()) {
                System.out.println("Ma san pham : ");
                String id = input.nextLine();

                System.out.println("Ten san pham : ");
                String name = input.nextLine();

                System.out.println("Ngay san xuat : ");
                String date = input.nextLine();

                System.out.println("Don gia : ");
                double price = input.nextDouble();

                System.out.println("So luong : ");
                int quantity = input.nextInt();

                Product product = new Product(id, name, date, price, quantity);
                App.PRODUCTS.add(product);

            } else {
                System.out.println("Ma san pham : ");
                String id = input.nextLine();

                Product product = null;

                for (Product p : App.PRODUCTS) {
                    if (p.getId().equals(id)) {
                        product = p;
                        break;
                    }
                }

                if (product == null) {
                    System.out.println("Ten san pham : ");
                    String name = input.nextLine();

                    System.out.println("Ngay san xuat : ");
                    String date = input.nextLine();

                    System.out.println("Don gia : ");
                    double price = input.nextDouble();

                    System.out.println("So luong : ");
                    int quantity = input.nextInt();

                    Product pr = new Product(id, name, date, price, quantity);
                    App.PRODUCTS.add(pr);

                } else {
                    for (Product p : App.PRODUCTS) {
                        if (product.equals(p)) {
                            System.out.println("Bo sung so luong : ");
                            int quantity = input.nextInt();
                            p.setQuantity(quantity + product.getQuantity());
                        }
                    }
                }
            }
        } catch (InputMismatchException ei) {
            System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // In danh sach cac san pham ma sieu thi co
    public void show() {
        System.out.println("\t\t\t---------------------------");
        System.out.println("DANH SACH SAN PHAM");

        for (Product p : App.PRODUCTS) {
            System.out.println(p);
        }

        System.out.println("\t\t\t---------------------------");

    }
}
