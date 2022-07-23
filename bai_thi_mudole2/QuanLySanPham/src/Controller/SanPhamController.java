package Controller;

import Service.Iml.SanPhamSevice;

import java.util.Scanner;

public class SanPhamController {

    private static SanPhamSevice sanPhamSevice = new SanPhamSevice();
    public static void displaySanPhamMenu() {

        System.out.println("=============Quản lý sản phẩm==============");
        do {
            System.out.println("****Chọn chức năng hệ thống****" +
                    "\n 1.Thêm mới" +
                    "\n 2.Xóa" +
                    "\n 3.Xem danh sách " +
                    "\n 4.Tìm kiếm" +
                    "\n 5.Thoát ");
            Scanner scanner = new Scanner(System.in);
            System.out.println("****Chọn chức năng theo số****");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("===========Thêm mới ===========");
                    sanPhamSevice.add();
                    break;
                case "2":
                    System.out.println("===========Xóa===========");
                    sanPhamSevice.delete();
                    break;
                case "3":
                    System.out.println("===========Xem danh sách ===========");
                    sanPhamSevice.display();
                    break;
                case "4":
                    System.out.println("===========Tìm kiếm===========");
                    sanPhamSevice.find();
                    break;
                case "5":
                    System.out.println("===========Good bye===========");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhâp từ 1 đến 5");

            }
        } while (true);
    }
}
