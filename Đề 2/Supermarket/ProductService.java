package Supermarket;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductService {

    private Scanner sc = new Scanner(System.in);

    public ProductService() {
    }

    // Sieu thi nhap them 1 san pham
    public void insert() {
        System.out.println("NHAP THONG TIN SAN PHAM");

        try {
            if (App.PRODUCTS.isEmpty()) {
                System.out.println("Ma : ");
                String id = sc.nextLine();

                System.out.println("Ten san pham : ");
                String productName = sc.nextLine();

                System.out.println("Ngay san pham : ");
                String productionDate = sc.nextLine();

                System.out.println("Don gia : ");
                double price = sc.nextDouble();

                System.out.println("So luong : ");
                Integer quantity = sc.nextInt();

                Product product = new Product(id, productName, productionDate, price, quantity);
                App.PRODUCTS.add(product);

            } else {
                System.out.println("Ma : ");
                String id = sc.nextLine();

                Product product = null;

                for (Product p : App.PRODUCTS) {
                    if (p.getId().equals(id)) {
                        product = p;
                        break;
                    }
                }

                if (product != null) {
                    for (int i = 0; i < App.PRODUCTS.size(); i++) {
                        if (App.PRODUCTS.get(i).getId().equals(id)) {
                            System.out.println("Bo sung so luong : ");
                            Integer quantity = sc.nextInt();
                            Integer originalQuantity = App.PRODUCTS.get(i).getQuantity();
                            App.PRODUCTS.get(i).setQuantity(quantity + originalQuantity);
                        }
                    }
                } else {
                    System.out.println("Ten san pham : ");
                    String productName = sc.nextLine();

                    System.out.println("Ngay san pham : ");
                    String productionDate = sc.nextLine();

                    System.out.println("Don gia : ");
                    double price = sc.nextDouble();

                    System.out.println("So luong : ");
                    Integer quantity = sc.nextInt();

                    Product pr = new Product(id, productName, productionDate, price, quantity);
                    App.PRODUCTS.add(pr);
                }
            }

        } catch (InputMismatchException ei) {
            System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // In danh sach cac san pham ma sieu thi co.
    public void show() {
        System.out.println("\t\t\t---------------------------");
        System.out.println("DANH SACH SAN PHAM");
        for (Product product : App.PRODUCTS) {
            System.out.println(product);
        }
        System.out.println("\t\t\t---------------------------");
    }

    // Sieu thi thay doi thong tin cua 1 san pham.
    public void update() {
        try {
            System.out.println("Nhap ma san pham : ");
            String id = sc.nextLine();
            Product product = null;

            for (Product p : App.PRODUCTS) {
                if (p.getId().equals(id)) {
                    product = p;
                    break;
                }
            }

            if (product == null) {
                System.out.println("Ma san pham khong ton tai!");
            } else {
                System.out.println("THONG TIN SAN PHAM");
                System.out.println(product);

                for (int i = 0; i < App.PRODUCTS.size(); i++) {
                    if (App.PRODUCTS.get(i).getId().equals(id)) {
                        System.out.println("Ten san pham : ");
                        App.PRODUCTS.get(i).setProductName(sc.nextLine());

                        System.out.println("Ngay san pham : ");
                        App.PRODUCTS.get(i).setProductionDate(sc.nextLine());

                        System.out.println("Don gia : ");
                        App.PRODUCTS.get(i).setPrice(sc.nextDouble());

                        System.out.println("So luong : ");
                        App.PRODUCTS.get(i).setQuantity(sc.nextInt());

                    }
                }
            }

        } catch (InputMismatchException ei) {
            System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // lay ra 1 san pham
    public Product getById(String id) {
        Product product = new Product();

        for (Product p : App.PRODUCTS) {
            if (p.getId().equals(id)) {
                product = p;
                break;
            }
        }
        return product;
    }

}
