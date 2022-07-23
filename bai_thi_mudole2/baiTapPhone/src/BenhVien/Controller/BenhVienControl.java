package BenhVien.Controller;

import BenhVien.Service.Iml.BenhVienService;
import BenhVien.Uliti.Regex;

import java.util.Scanner;

public class BenhVienControl {
    private static BenhVienService benhVienService = new BenhVienService();
    public static void displayBenhVienMenu() {

        System.out.println("=============Quản lý bệnh viện==============");
        do {
            System.out.println("****Chọn chức năng hệ thống****" +
                    "\n 1.Thêm mới " +
                    "\n 2.Xóa" +
                    "\n 3.Xem danh sách các bệnh án " +
                    "\n 4.Thoát " );
            Scanner scanner = new Scanner(System.in);
            System.out.println("****Chọn chức năng theo số****");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("===========Thêm mới===========");
                    benhVienService.add();
                    break;
                case "2":
                    System.out.println("===========Xóa ===========");
                    benhVienService.delete();
                    break;
                case "3":
                    System.out.println("===========Xem danh sách các bệnh án===========");
                    benhVienService.display();
                    break;
                case "4":
                    System.out.println("=================Tạm biệt===========");
                    System.out.println("===========Chúc một ngày tốt lành===========");
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

            System.out.println("Day Type dd/mm/yyyy");
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
                System.out.println("DAY out must Bigger date in ");
                date = scanner.nextLine();
                continue;
            }
            System.out.println("day wrong type dd/mm/yyyy");
            date = scanner.nextLine();
        }
        return date;
    }
}
