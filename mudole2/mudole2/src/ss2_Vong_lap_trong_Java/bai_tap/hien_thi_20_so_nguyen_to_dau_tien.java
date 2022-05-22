package ss2_Vong_lap_trong_Java.bai_tap;

public class hien_thi_20_so_nguyen_to_dau_tien {
    public static void main(String[] args) {
        int n = 2, count = 0;
        while (count < 20) {
            int count1 = 0;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    count1++;
                }
            }
            if (count1==0){
                System.out.println(count+": "+n);
                count++;
            }
            n++;
        }

    }
}
