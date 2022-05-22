package ss3_Mang_va_phuong_thuc_trong_Java.bai_tap;

import java.util.Scanner;

public class tim_gia_tri_nho_nhat_trong_mang {
    public static void main(String[] args) {
        int size ;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhập số lượng phần tử");
            size = scanner.nextInt();
            if (size<=0){
                System.out.println("Số lượng phần tử không đc nhỏ hơn 0");
            }
        }while (size <=0);
        int [] arr = new int[size];
        for (int i = 0; i <size ; i++) {
            System.out.println("Nhập phần tử vào mảng" );
            arr[i] = scanner.nextInt();
        }
       int min = minValue(arr);
        System.out.println("Giá trị nhỏ nhất trong mảng là: " + min);




    }
    public static int minValue(int []array ){
        int min = array[0];
        for (int i = 0; i <array.length ; i++) {
            if(min >array[i]){
                min = array[i];
            }
        }
        return min;


    }

}
