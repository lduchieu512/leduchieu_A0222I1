package ss3_Mang_va_phuong_thuc_trong_Java.bai_tap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class them_phan_tu_vao_mang {
    public static void main(String[] args) {
        int[] a = {10, 4, 5, 6, 7, 8, 6};
        Scanner scanner = new Scanner(System.in);

        int index;
        do {
            System.out.println("Nhập chỉ số index để thêm vào mảng");
            index = scanner.nextInt();
            if (index <= 1 || index >= a.length - 1) {
                System.out.println("Không thể chèn vào mảng");
            }
        } while (index <= 1 || index >= a.length - 1);
        System.out.println("Nhập giá trị vào mảng");
        int value = scanner.nextInt();
        int[] newArr = add(a, index, value);
        System.out.println(Arrays.toString(newArr));
    }

    public static int[] add(int[] old, int index, int val) {
        int[] tmp = Arrays.copyOf(old, old.length + 1);
        for (int i = tmp.length - 1; i < index; i--) {
            tmp[i] = old[i - 1];
        }
        tmp[index] = val;
        return tmp;


    }
}
