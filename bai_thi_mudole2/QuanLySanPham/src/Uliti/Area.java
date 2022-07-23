package Uliti;

import java.util.Scanner;

public class Area {
    public static String tinhThanh() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****Khu vực tỉnh hàng****\n" +
                "1. Đà Nẵng \n" +
                "2. Hà Nội \n" +
                "3. Hải Phòng \n" +
                "4. Sài Gòn");
        System.out.println("Chọn khu vực");
        String choose = scanner.nextLine();
        do {
            switch (choose) {
                case "1":
                    return "Đà Nẵng";
                case "2":
                    return "Hà Nội";
                case "3":
                    return "Hải Phòng";
                case "4":
                    return "Sài Gòn";

                default:
                    return "Chỉ nhập 1 - 3";
            }
        } while (true);
    }
    public static String quocGia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****Khu vực quốc gia****\n" +
                "1. Việt Nam \n" +
                "2. USA \n" +
                "3. China \n" +
                "4. Russia");
        System.out.println("Chọn khu vực");
        String choose = scanner.nextLine();
        do {
            switch (choose) {
                case "1":
                    return "Việt Nam";
                case "2":
                    return "USA";
                case "3":
                    return "China";
                case "4":
                    return "Russia";

                default:
                    return "Chỉ nhập 1 - 3";
            }
        } while (true);
    }
}
