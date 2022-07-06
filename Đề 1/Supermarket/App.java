package Supermarket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Le Hong Lien
 */
public class App {

    public static List<Product> PRODUCTS = new ArrayList<Product>();
    public static List<Order> ORDERS = new ArrayList<Order>();
    public static int cout = 0;

    public static void main(String[] args) {
        int function = -1;

        while (function != 0) {
            Scanner inputs = new Scanner(System.in);
            menu();

            try {
                System.out.println("Chon chuc nang : ");
                function = inputs.nextInt();
                ProductService productService = new ProductService();
                OrderService orderService = new OrderService();

                switch (function) {
                    case 1:
                        productService.insert();
                        break;
                    case 2:
                        orderService.insert();
                        break;
                    case 3:
                        orderService.editNameOrBirthyear();
                        break;
                    case 4:
                        productService.show();
                        break;
                    case 5:
                        orderService.sort();
                        break;
                    case 6:
                        orderService.show();
                        break;
                }
            } catch (InputMismatchException ei) {
                System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void menu() {
        System.out.println("\t\t\t----------MENU-------------");
        System.out.println("""
                           1. Sieu thi nhap them 1 san pham. 
                           2. Sieu thi them 1 khach hang moi va mua san pham. 
                           3. Sieu thi thay doi ten hoac nam sinh khach hang. 
                           4. In danh sach cac san pham ma sieu thi co. 
                           5. Sap xep tang dan so tien ma khach hang da mua. 
                           6. In danh sach cac khach hang.
                           0. Thoat chuong trinh""");
        System.out.println("\t\t\t---------------------------");
    }
}

