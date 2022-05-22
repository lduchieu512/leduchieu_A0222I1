package ss2_Vong_lap_trong_Java.thuc_hanh;

import java.util.Scanner;

public class ung_dung_tinh_tien_lai_cho_vay {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;
        double totalInterest = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter investment amount: ");
        money = scanner.nextDouble();

        System.out.println("Enter number of months: ");
        month = scanner.nextInt();

        System.out.println("Enter annual interest rate in percentage: ");
        interestRate = scanner.nextDouble();

        for (int i = 0; i < month; i++) {
            totalInterest += money * (interestRate/100)/12*month;
        }
        System.out.println("Total of interest: " + totalInterest);


    }
}
