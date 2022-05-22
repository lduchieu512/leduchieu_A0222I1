package ss3_Mang_va_phuong_thuc_trong_Java.bai_tap;

import java.util.Scanner;

public class xoa_phan_tu_khoi_mang {
    public static void main(String[] args) {
        int[] a = {10, 4, 5, 6, 7, 8, 6};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value remote: ");
        int value = scanner.nextInt();

        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == value) {
                index = i;
            }
        }
        for (int i = index; i < a.length -1; i++) {
            a[i] = a[i + 1];
        }
        for (int i = 0; i < a.length -1; i++) {
            System.out.print(a[i] + "\t");
        }


    }


}
