package Supermarket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lê Hồng Liên
 */
public class App {

    public static List<Product> PRODUCTS = new ArrayList<Product>();
    public static List<Order> ORDERS = new ArrayList<Order>();
    public static int cout = 0;

    public static void menu() {
        System.out.println("\t\t\t----------MENU-------------");
        System.out.println("""
                           1. Sieu thi nhap them 1 san pham. 
                           2. Sieu thi them 1 khach hang moi. 
                           3. Sieu thi thay doi thong tin cua 1 san pham. 
                           4. In danh sach cac san pham ma sieu thi co. 
                           5. Hien thi ra man hinh khach hang co tong so tien da mua lon nhat. 
                           6. In danh sach cac khach hang
                           0. Thoat chuong trinh""");
        System.out.println("\t\t\t---------------------------");

    }

    public static void main(String[] args) {

        int function = 0;

        do {
            menu();
            Scanner input = new Scanner(System.in);

            try {
                System.out.println("Chon chuc nang : ");
                function = input.nextInt();
                ProductService productService = new ProductService();
                OrderService orderService = new OrderService();

                switch (function) {
                    case 1:
                        productService.insert();
                        break;
                    case 2:
                        orderService.order();
                        break;
                    case 3:
                        productService.update();
                        break;
                    case 4:
                        productService.show();
                        break;
                    case 5:
                        orderService.showMaxTotalPrice();
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

        } while (function!= 0);

        System.out.println(
                "Cam on ban da su dung phan mem!");
    }

}
