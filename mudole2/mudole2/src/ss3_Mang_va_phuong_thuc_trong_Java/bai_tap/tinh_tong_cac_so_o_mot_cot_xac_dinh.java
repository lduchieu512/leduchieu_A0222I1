package ss3_Mang_va_phuong_thuc_trong_Java.bai_tap;

import java.util.Scanner;

public class tinh_tong_cac_so_o_mot_cot_xac_dinh {
    public static void main(String[] args) {
//        int [][]arr={
//                {1,2,3,4,5},
//                {6,7,8,9,10},
//                {11,12,13,14,15}
//        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số dòng: ");
        int soDong = scanner.nextInt();
        System.out.println("Nhập số cột: ");
        int soCot = scanner.nextInt();
        int [][]arr = new int[soDong][soCot];
        for (int i = 0; i <soDong ; i++) {
            for (int j = 0; j <soCot ; j++) {
                System.out.println("Nhập phần tử ["+i+"]["+j+"]: ");
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }



        int cot ,tongCot = 0;
        System.out.println("Tính tổng cột số bao nhiêu: ");
        cot =scanner.nextInt();
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if (arr[i][j]== arr[i][cot-1] ){
                    tongCot += arr[i][cot-1];
                }
            }
        }
        System.out.println("Tổng các phần tử ở cột thứ "+cot+" là: "+tongCot);

    }
}
