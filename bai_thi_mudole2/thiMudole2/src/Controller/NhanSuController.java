package Controller;

import Service.Iml.NhanSuService;
import Utili.Regex;

import java.util.Scanner;

public class NhanSuController {
    private static NhanSuService benhVienService = new NhanSuService();
    public static void displayNhanSuMenu() {

        System.out.println("============= Quản lý nhân sự ==============");
        do {
            System.out.println("**** Chọn chức năng hệ thống ****" +
                    "\n 1.Thêm mới nhân sự" +
                    "\n 2.Xóa nhân sự" +
                    "\n 3.Xem danh sách nhân sự " +
                    "\n 4.Thoát " );
            Scanner scanner = new Scanner(System.in);
            System.out.println("**** Chọn chức năng theo số ****");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("=========== Thêm mới nhân sự ===========");
                    benhVienService.add();
                    break;
                case "2":
                    System.out.println("=========== Xóa nhân sự ===========");
                    benhVienService.delete();
                    break;
                case "3":
                    System.out.println("=========== Xem danh sách các nhân sự ===========");
                    benhVienService.display();
                    break;
                case "4":
                    System.out.println("=================Tạm biệt ===========");
                    System.out.println("===========Chúc một ngày tốt lành ===========");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhâp từ 1 đến 4");

            }
        } while (true);
    }
    public static String getDateCorrect(String line) {
        String date = line;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            if (Regex.isCorrectTypeDate(date)) {
                break;
            }

            System.out.println("Kiểu ngày dd/mm/yyyy");
            date = scanner.nextLine();
        }
        return date;
    }

    public static String getDateOut(String line, String dateIn) {
        String date = line;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            if (Regex.isCorrectTypeDate(date)) {
                if (Regex.isBiggerDate(date, dateIn)) {
                    break;
                }
                System.out.println("Ngày nhập học phải lớn hơn ngày sinh");
                date = scanner.nextLine();
                continue;
            }
            System.out.println("Nhập sai dd/mm/yyyy");
            date = scanner.nextLine();
        }
        return date;
    }
}
