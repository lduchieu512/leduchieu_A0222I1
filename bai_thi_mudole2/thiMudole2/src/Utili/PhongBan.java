package Utili;

import java.util.Scanner;

public class PhongBan {
    public static String area() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****Chọn phòng ban***\n" +
                "1. Đào tạo \n" +
                "2. Tuyển sinh \n" +
                "3. Truyền thông");
        System.out.println("Chọn phòng ban");
        int choose = Integer.parseInt(scanner.nextLine());
        do {
            switch (choose) {
                case 1:
                    return "Đào tạo";
                case 2:
                    return "Tuyển sinh";

                default:
                    return "Truyền thông";
            }
        } while (true);
    }
}
