package bai_thi.hr_controller;



import bai_thi.hr_service.HRService;

import java.util.Scanner;

public class PersonalController {
    private static HRService hrService = new HRService();
    public static void display() {

        System.out.println("=============Quản Lý Nhân Sự==============");
        do {
            System.out.println("****Chọn chức năng hệ thống****" +
                    "\n 1.Thêm mới/Add new" +
                    "\n 2.Xóa/Delete" +
                    "\n 3.Xem danh sách/View list" +
                    "\n 4.Thoát/Exit ");
            Scanner scanner = new Scanner(System.in);
            System.out.println("****Chọn chức năng theo số****");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("===========Thêm mới/Add new===========");
                    hrService.addNew();
                    break;
                case "2":
                    System.out.println("===========Xóa/Delete===========");
                    hrService.delete();
                    break;
                case "3":
                    System.out.println("===========Xem danh sách/View list===========");
                    hrService.display();
                    break;
                case "4":
                    System.out.println("Thoát");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhâp từ 1 đến 4");

            }
        } while (true);
    }
}
