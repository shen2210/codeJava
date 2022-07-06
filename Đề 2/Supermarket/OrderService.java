package Supermarket;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderService {

    private Scanner sc = new Scanner(System.in);

    // them 1 khach moi va khach hang mua san pham
    public void order() {
        System.out.println("THEM KHACH HANG MOI & MUA SAN PHAM");

        try {
            System.out.println("Ma khach hang : ");
            String id = sc.nextLine();

            Order order = null;

            for (Order o : App.ORDERS) {
                if (o.getId().equals(id)) {
                    order = o;
                    break;
                }
            }

            double totalPrice = 0;

            if (order == null) {
                System.out.println("---Them 1 khanh hang moi : ");
                System.out.println("Ten khach hang : ");
                String customerName = sc.nextLine();

                System.out.println("Nam sinh : ");
                Integer birthYear = sc.nextInt();

                Address address = new Address();
                address.inputAddress();

                order = new Order(id, customerName, birthYear, address);

                while (true) {
                    sc = new Scanner(System.in);

                    System.out.println("Nhap ma san pham : ");
                    String productId = sc.nextLine();

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
                        double priceProduct = sc.nextDouble();

                        System.out.println("Nhap so luong : ");
                        int quantity = sc.nextInt();

                        if ((product.getQuantity() < quantity) || (quantity < 0)) {
                            System.out.println("So luong mua khong hop le!");
                        } else {
                            for (Product pr : App.PRODUCTS) {
                                if (pr.getId().equals(productId)) {
                                    pr.setQuantity(pr.getQuantity() - quantity);
                                    break;
                                }
                            }

                            double money = priceProduct * quantity;

                            OrderDetail orderDetail = new OrderDetail();
                            orderDetail.setId(++App.cout);
                            orderDetail.setOrderId(order.getId());
                            orderDetail.setPriceProduct(priceProduct);
                            orderDetail.setPrice(money);
                            orderDetail.setProductId(productId);
                            orderDetail.setQuantity(quantity);

                            totalPrice += money;
                            order.getOrderDetails().add(orderDetail);
                        }

                    }
                }

                order.setTotalPrice(totalPrice);
                App.ORDERS.add(order);

            } else {
                System.out.println("---Khanh hang mua san pham : ");

                while (true) {
                    sc = new Scanner(System.in);

                    System.out.println("Nhap ma san pham : ");
                    String productId = sc.nextLine();

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
                        double priceProduct = sc.nextDouble();

                        System.out.println("Nhap so luong : ");
                        int quantity = sc.nextInt();

                        if ((product.getQuantity() < quantity) || (quantity < 0)) {
                            System.out.println("So luong mua khong hop le!");
                        } else {
                            for (Product pr : App.PRODUCTS) {
                                if (pr.getId().equals(productId)) {
                                    pr.setQuantity(pr.getQuantity() - quantity);
                                    break;
                                }
                            }
                            double money = priceProduct * quantity;

                            OrderDetail oderDetail = new OrderDetail();
                            oderDetail.setId(++App.cout);
                            oderDetail.setOrderId(order.getId());
                            oderDetail.setPriceProduct(priceProduct);
                            oderDetail.setPrice(priceProduct * quantity);
                            oderDetail.setProductId(productId);
                            oderDetail.setQuantity(quantity);

                            totalPrice += money;
                            order.getOrderDetails().add(oderDetail);
                        }
                    }
                }
                order.setTotalPrice(order.getTotalPrice() + totalPrice);

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
        System.out.println("DANH SACH MUA HANG");
        ProductService productService = new ProductService();

        for (Order order : App.ORDERS) {
            System.out.println(order);

            int i = 1;
            for (OrderDetail od : order.getOrderDetails()) {
                Product product = productService.getById(od.getProductId());

                System.out.println("STT = " + i + " ,Ten san pham : " + product.getProductName() + " ,Don gia : " + od.getPriceProduct() + " ,So luong mua : " + od.getQuantity() + " ,Thanh tien : " + od.getPrice());
                i++;
            }

            System.out.println("Tong tien : " + order.getTotalPrice());
        }
        System.out.println("\t\t\t---------------------------");

    }

    // Hien thi ra man hinh khach hang co tong so tien da mua lon nhat. 
    public void showMaxTotalPrice() {
        double maxPrice = 0;

        for (Order o : App.ORDERS) {
            if (o.getTotalPrice() > maxPrice) {
                maxPrice = o.getTotalPrice();
            }
        }

        System.out.println("\t\t\t---------------------------");
        System.out.println("KHACH HANG CO TONG SO TIEN DA MUA LON NHAT");
        System.out.println("Tong so tien da mua lon nhat : " + maxPrice);

        for (Order o : App.ORDERS) {
            if (o.getTotalPrice() == maxPrice) {
                System.out.println(o);
            }
        }

    }

}
