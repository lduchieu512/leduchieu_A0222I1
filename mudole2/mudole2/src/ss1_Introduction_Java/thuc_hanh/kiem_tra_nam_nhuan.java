package ss1_Introduction_Java.thuc_hanh;

import java.util.Scanner;

public class kiem_tra_nam_nhuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.println("Enter a year: ");
        year = scanner.nextInt();
//
//        if (year %4 ==0){
//            if (year %100 ==0){
//                if (year %400==0){
//                    System.out.printf("%d is a leap year", year);
//                } else {
//                    System.out.printf("%d is NOT a leap year", year);
//                }
//            }else {
//                System.out.printf("%d is a leap year", year);
//            }
//        }else {
//            System.out.printf("%d is NOT a leap year", year);
//        }

        boolean isLeapYear = false;

        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }

        if(isLeapYear){
            System.out.printf("%d is a leap year", year);
        } else {
            System.out.printf("%d is NOT a leap year", year);
        }












    }














}
