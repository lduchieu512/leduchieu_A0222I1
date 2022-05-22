package ss3_Mang_va_phuong_thuc_trong_Java.bai_tap;

import java.util.Scanner;

public class dem_so_lan_xuat_hien_cua_ky_tu_nam_trong_chuoi {
    public static void main(String[] args) {
        String str ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input");
        str = scanner.nextLine();
        String strSearch;
        System.out.println("Input search: ");
        strSearch = scanner.nextLine();
        char a = strSearch.charAt(0);
        int count=0;
        for (int i = 0; i <str.length() ; i++) {
            if (str.charAt(i) == a){
                count++;
            }
        }
        System.out.println("Ký tự "+a+" xuất hiện " +count+" lần");
    }
}
