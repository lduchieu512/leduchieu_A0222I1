package ss2_Vong_lap_trong_Java.bai_tap;

import java.util.Scanner;

public class hien_thi_cac_loai_hinh {
    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);

        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2.Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 15; j++) {
                            System.out.print("*  ");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print("*  ");
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    System.out.println("");
                    for (int i = 5; i > 0; i--) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("*  ");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    Scanner sc = new Scanner(System.in);
                    int hight, k = 0;
                    hight = 8;
                    for (int i = 1; i <= hight; ++i, k = 0) {
                        for (int space = 1; space <= hight - i; ++space) {
                            System.out.print("  ");
                        }
                        while (k != 2 * i - 1) {
                            System.out.print("* ");
                            ++k;
                        }
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println("No choice!");
            }


        }
    }
}
