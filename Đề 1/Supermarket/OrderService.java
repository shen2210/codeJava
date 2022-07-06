package Supermarket;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderService {

    Scanner input = new Scanner(System.in);

    // Sieu thi them 1 khach hang moi va mua san pham
    public void insert() {
        try {
            System.out.println("NHAP THONG TIN KHACH HANG MOI VA MUA SAN PHAM");

            System.out.println("Ma khach hang : ");
            String customerId = input.nextLine();

            Order order = null;

            for (Order o : App.ORDERS) {
                if (o.getId().equals(customerId)) {
                    order = o;
                    break;
                }
            }

            if (order == null) {
                System.out.println("---Them 1 khanh hang moi :");
                System.out.println("Ten khach hang : ");
                String customerName = input.nextLine();

                System.out.println("Nam sinh : ");
                Integer birthYear = input.nextInt();
                input.nextLine();

                Address address = new Address();
                address.inputAddress();

                order = new Order(customerId, customerName, birthYear, address);

                System.out.println("---Mua san pham");
                while (true) {
                    System.out.println("Ma san pham mua : ");
                    String productId = input.nextLine();

                    // neu nhap productId = 0 se dung 
                    if ("0".equals(productId)) {
                        break;
                    }

                    Product product = null;

                    for (Product p : App.PRODUCTS) {
                        if (p.getId().equals(productId)) {
                            product = p;
                            break;
                        }
                    }

                    if (product == null) {
                        System.out.println("Ma san pham khong ton tai!");
                    } else {
                        System.out.println("Nhap don gia san pham : ");
                        double priceProduct = input.nextDouble();

                        System.out.println("Nhap so luong : ");
                        int quantity = input.nextInt();
                        input.nextLine();

                        if ((product.getQuantity() < quantity) || (quantity < 0)) {
                            System.out.println("So luong mua khong hop le!");
                        } else {

                            for (Product p : App.PRODUCTS) {
                                if (product.equals(p)) {
                                    p.setQuantity(p.getQuantity() - quantity);
                                    break;
                                }
                            }

                            double money = priceProduct * quantity;

                            OrderDetail orderDetail = new OrderDetail();
                            orderDetail.setId(++App.cout);
                            orderDetail.setOrderId(customerId);
                            orderDetail.setProductId(productId);
                            orderDetail.setPriceProduct(priceProduct);
                            orderDetail.setQuantity(quantity);
                            orderDetail.setPrice(money);

                            order.getOrderDetails().add(orderDetail);
                        }
                    }
                }
                App.ORDERS.add(order);
            } else {
                System.out.println("---Khanh hang mua san pham!");

                while (true) {
                    System.out.println("Ma san pham mua : ");
                    String productId = input.nextLine();

                    // neu nhap productId = 0 se dung 
                    if ("0".equals(productId)) {
                        break;
                    }

                    Product product = null;

                    for (Product p : App.PRODUCTS) {
                        if (p.getId().equals(productId)) {
                            product = p;
                            break;
                        }
                    }

                    if (product == null) {
                        System.out.println("Ma san pham khong ton tai!");
                    } else {
                        System.out.println("Nhap don gia san pham : ");
                        double priceProduct = input.nextDouble();

                        System.out.println("Nhap so luong : ");
                        int quantity = input.nextInt();
                        input.nextLine();

                        if ((product.getQuantity() < quantity) || (quantity < 0)) {
                            System.out.println("So luong mua khong hop le!");
                        } else {

                            for (Product p : App.PRODUCTS) {
                                if (product.equals(p)) {
                                    p.setQuantity(p.getQuantity() - quantity);
                                    break;
                                }
                            }

                            double money = priceProduct * quantity;

                            OrderDetail orderDetail = new OrderDetail();
                            orderDetail.setId(++App.cout);
                            orderDetail.setOrderId(customerId);
                            orderDetail.setProductId(productId);
                            orderDetail.setPriceProduct(priceProduct);
                            orderDetail.setQuantity(quantity);
                            orderDetail.setPrice(money);

                            order.getOrderDetails().add(orderDetail);
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

    // In danh sach cac khach hang
    public void show() {
        System.out.println("\t\t\t---------------------------");
        System.out.println("DANH SACH KHACH HANG");

        for (Order order : App.ORDERS) {
            System.out.println(order);
            int i = 1;

            for (OrderDetail od : order.getOrderDetails()) {
                Product p = null;

                for (Product product : App.PRODUCTS) {
                    if (product.getId().equals(od.getProductId())) {
                        p = product;
                        break;
                    }
                }

                if (p != null) {
                    System.out.println("STT = " + i + " ,Ten san pham = " + p.getNameProduct() + " ,Don gia = " + od.getProductId() + " ,So luong = " + od.getQuantity() + " ,Thanh tien = " + od.getPrice());
                    i++;
                }
            }
        }
        System.out.println("\t\t\t---------------------------");
    }

    // Sieu thi thay doi ten hoac nam sinh khach hang.
    public void editNameOrBirthyear() {
        try {
            System.out.println("Nhap ma khach hang : ");
            String customerId = input.nextLine();

            Order order = null;

            for (Order o : App.ORDERS) {
                if (o.getId().equals(customerId)) {
                    order = o;
                    break;
                }
            }

            if (order == null) {
                System.out.println("Ma khach hang khong ton tai!");
            } else {
                while (true) {
                    System.out.println("\t\t\t---------------------------");
                    System.out.println("CHINH SUA THONG TIN KHACH HANG");
                    System.out.println("1. Chinh sua ten khach hang.");
                    System.out.println("2. Chinh sua nam sinh khach hang.");
                    System.out.println("0. Thoat.");
                    System.out.println("\t\t\t---------------------------");
                    System.out.println(order);
                    System.out.print("Chon chuc nang chinh sua : ");
                    int function = input.nextInt();

                    if (function == 1) {
                        input.nextLine();
                        System.out.println("Nhap ten khach hang : ");
                        String name = input.nextLine();

                        for (Order o : App.ORDERS) {
                            if (order.equals(o)) {
                                o.setCustomerName(name);
                            }
                        }

                        System.out.println("Chinh sua ten khach hang thanh cong!");

                    } else if (function == 2) {
                        System.out.println("Nhap nam sinh khach hang : ");
                        int year = input.nextInt();

                        for (Order o : App.ORDERS) {
                            if (order.equals(o)) {
                                o.setBirthYear(year);
                            }
                        }

                        System.out.println("Chinh sua nam sinh khach hang thanh cong!");

                    } else if (function == 0) {
                        break;
                    }
                }
            }
        } catch (InputMismatchException ei) {
            System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // Sap xep tang dan so tien ma khach hang da mua.
    public void sort() {

        for (Order order : App.ORDERS) {
            order.sortByPrice();
        }

        System.out.println("SAP XEP TANG DAN SO TIEN KHACH HANG DA MUA");
        this.show();

    }
}
