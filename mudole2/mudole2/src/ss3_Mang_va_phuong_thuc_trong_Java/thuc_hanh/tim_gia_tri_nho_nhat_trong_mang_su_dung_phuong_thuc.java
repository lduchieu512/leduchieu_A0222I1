package ss3_Mang_va_phuong_thuc_trong_Java.thuc_hanh;

import java.util.Scanner;

public class tim_gia_tri_nho_nhat_trong_mang_su_dung_phuong_thuc {
    public static void main(String[] args) {
        int size;
        int [] array;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter size: ");
            size = scanner.nextInt();
            if (size>20){
                System.out.println("Size should not exceed 20");

            }
        }while (size>20);

        array = new int [size];
        int i=0;
        while (i<array.length){
            System.out.print("Enter element " + (i+1)+": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Property list: ");
        for (int j = 0; j <array.length ; j++) {
            System.out.print(array[j]+"\t");
        }
        int index = minValue(array);
        System.out.println("The smallest element in the array is: " + array[index]);
    }
    public static int minValue(int[] array){
        int index = 0;
        for (int i = 1; i < array.length ; i++) {
                if (array[i]< array[index]){
                    index =i;
                }
        }
        return index;
    }
}
