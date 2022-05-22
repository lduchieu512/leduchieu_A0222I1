package ss2_Vong_lap_trong_Java.bai_tap;

public class hien_thi_cac_so_nguyen_to_nho_hon_100 {
    public static void main(String[] args) {
        int number = 2, count = 0;
        while (count < 50) {
            int count1 = 0;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    count1++;
                }
            }
            if (count1 == 0) {
                if (number < 100) {
                    System.out.println(count + ": " + number);
                    count++;
                }
            }
            number++;
        }


    }
}
