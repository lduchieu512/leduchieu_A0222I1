package BenhVien.Uliti;

import java.util.Scanner;

public class ChonVip {
    public static String area() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****Chọn VIP***\n" +
                "1. VIP1 \n" +
                "2. VIP2 \n" +
                "3. VIP3");
        System.out.println("Chọn VIP");
        int choose = Integer.parseInt(scanner.nextLine());
        do {
            switch (choose) {
                case 1:
                    return "VIP1";
                case 2:
                    return "VIP2";

                default:
                    return "VIP3";
            }
        } while (true);
    }
}
