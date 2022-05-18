package ss1_Introduction_Java.bai_tap;

import java.util.Scanner;

public class chuyen_doi_tien_te {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số tiền USD:  ");
        usd = sc.nextDouble();
        double quydoi = usd *vnd;
        System.out.println("Giá trị VND: "+quydoi);

    }
}
