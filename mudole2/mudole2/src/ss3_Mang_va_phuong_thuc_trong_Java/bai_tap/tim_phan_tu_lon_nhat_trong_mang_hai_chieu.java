package ss3_Mang_va_phuong_thuc_trong_Java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class tim_phan_tu_lon_nhat_trong_mang_hai_chieu {
    public static void main(String[] args) {
//        int [][] arr1 ={
//                {1,116,3,9},
//                {5,2,-123,4},
//                {2,7,12,-4},
//                {-12,4}
//        };

        int soDong,soCot;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số dòng ma trận");
        soDong = scanner.nextInt();
        System.out.println("Nhập số cột ma trận");
        soCot = scanner.nextInt();
        int [][]arr1 = new int[soDong][soCot];

        for (int i = 0; i <soDong ; i++) {
            for (int j = 0; j <soCot ; j++) {
                System.out.print("Nhập phần tử thứ ["+i+","+j+"]: ");
                arr1 [i][j] =scanner.nextInt();
            }
        }
        show(arr1);

        int max = arr1 [0][0];
        for (int i = 0; i <arr1.length ; i++) {
            for (int j = 0; j <arr1[i].length ; j++) {
                if (max < arr1[i][j]){
                    max =arr1[i][j];
                }

            }
        }
        System.out.println("Giá trị lươn nhất trong mảng: "+max);
    }
    public static void  show(int [][] arr ){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " \t");
            }
            System.out.println();
        }
    }




}
