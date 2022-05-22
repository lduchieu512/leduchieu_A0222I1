package ss3_Mang_va_phuong_thuc_trong_Java.bai_tap;

public class tinh_tong_cac_so_o_duong_cheo_chinh_cua_ma_tran {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int tongArr = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    tongArr += arr[i][j];
                }
            }
        }
        System.out.println("Tổng các phần tử của một ma trận vuông: " + tongArr);


    }
}
