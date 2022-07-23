package controllers;

import file_csv.File;
import models.Genuine;
import services.AddGenuine;

import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        displayMenu();
    }

    private static void displayMenu(){
        int choise;

        boolean check = true;
        do {
            System.out.println("--CHuong trinh quan li dien thoai--");
            System.out.println("1. Them moi \n2. Xem danh sach \n3. Sua \n4. Tim kiem \n5.  Thoat " );
            System.out.print("Nhap chuc nang : ");
            choise = sc.nextInt();

            switch (choise){
                case 1:
                        add();
                        break;
                case 2:
                    
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5: System.exit(0);
                    break;
                default: check = false;
                    break;


            }
        } while (check);



    }

        private static void add(){
            int choise,warrantyTime,warrantyCode ;
            double price;
            String name,brand ;
            System.out.println("Them moi \n1.Hang chinh hang \n 2.Hang xach tay");
            choise = sc.nextInt();
            switch (choise){
                case 1:
                    System.out.println("Ten dien thoai");
                    name = sc.nextLine();
                    name = sc.nextLine();
                    System.out.println("Nhap hang dien thoai");
                    brand = sc.nextLine();
                    System.out.println("Nhap gia tien");
                    price = Double.parseDouble(sc.nextLine());
                    System.out.println("Thoi gian bao hanh");
                    warrantyTime = sc.nextInt();
                    System.out.println("Ma bao hanh");
                    warrantyCode = sc.nextInt();
                    Genuine genuine = new Genuine(price,name,brand,warrantyTime,warrantyCode);
                    AddGenuine.add(genuine);
                    File.write();
                    break;
                case 2:
                    break;
                default:
                    break;
            }

        }


}
