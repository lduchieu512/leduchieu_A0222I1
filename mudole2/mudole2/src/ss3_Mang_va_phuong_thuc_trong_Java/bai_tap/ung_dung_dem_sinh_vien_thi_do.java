package ss3_Mang_va_phuong_thuc_trong_Java.bai_tap;

import java.util.Scanner;

public class ung_dung_dem_sinh_vien_thi_do {
    public static void main(String[] args) {
        int size ;
        int[] array;
        Scanner  scanner = new Scanner(System.in);
        do{
            System.out.print("Nhập số lượng sinh viên đã thi: ");
            size = scanner.nextInt();
            if (size>30 || size<=0){
                System.out.println("Chỉ nhập được 30 sinh viên, xin vui lòng nhập lại");
            }
        }while (size>30 || size<=0);
        array = new int[size];
        int i = 0;
        while (i<size){
            System.out.println("Nhập điểm: ");
            array[i] = scanner.nextInt();
            i++;
        }
        int count =0;
        System.out.println("Điểm của  sinh viên");
        for (int j = 0; j <array.length ; j++) {
            System.out.print(array[j]+"\t");
            if (array[j]>=5 && array[j]<=10){
                count++;
            }
        }
        System.out.print("\n Số sinh viên đỗ kì thi " + count);



    }



}
