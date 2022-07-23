package Utili;

import Model.NhanSu;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    static Scanner scanner = new Scanner(System.in);
    public static final String REGEX_STR = "^[a-zA-Z\\s\\W|_]+$";
    public static final String REGEX_PHONE_NUMBER = "^(\\+84|0)\\d{9}$";
    public static final String REGEX_NUMBERDOUBLE = "^\\d+\\.*\\d*$";
    public static final String REGEX_NUMBER = "^\\d+$";
    public static final String REGEX_HOCVIEN = "^(HV)-\\d{3}$";
    public static final String REGEX_NHANVIEN = "^(NV)-\\d{3}$";

    public static String regexStr(String temp, String regex, String error) {
        boolean flag = true;
        do {
            if (temp.matches(regex)) {
                flag = false;
            } else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        } while (flag);
        return temp;
    }


    public  static  String checkAddress(){return regexStr(scanner.nextLine(),REGEX_STR,"Nhập sai");}
    public static String checkStr(){return regexStr(scanner.nextLine(),REGEX_STR,"Nhập sai");}
    public static String checkPhone(){
        return regexStr(scanner.nextLine(),REGEX_PHONE_NUMBER,"Nhập sai, số điện thoại 10 số (0xxxxxxxxx). Vui lòng nhập lại");
    }


    //Kiểm tra  mã ID
    public static  boolean checkImportCode(String x){
        String REGEX_IMPORT_CODE = "^(NK)-[0-9][1-9]*$";
        boolean check = x.matches(REGEX_IMPORT_CODE);
        return  check;
    }
    public static  boolean checkExportCode(String x){
        String REGEX_EXPORT_CODE = "^(XK)-[0-9][1-9]*$";
        boolean check = x.matches(REGEX_EXPORT_CODE);
        return  check;
    }
    public static  boolean checkIDCard(String x){
        String REGEX_ID = "^[0-9]{9}||[0-9]{12}$";
        boolean check = x.matches(REGEX_ID);
        return  check;
    }

    public static String inputStr() {
        return Regex.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng!");
    }

   public static String inputNumber() {
       return Regex.regexStr(scanner.nextLine(), REGEX_NUMBER, "Bạn đã nhập sai, xin hãy nhập số lớn hơn 0!");
   }

    public static String inputNumberDouble() {
        return Regex.regexStr(scanner.nextLine(), REGEX_NUMBERDOUBLE, "Bạn đã nhập sai, xin hãy nhập số lớn hơn 0!");
    }

    public static String inputNhanVien() {
        return Regex.regexStr(scanner.nextLine(), REGEX_NHANVIEN, "Bạn đã nhập sai mã định danh, mã định danh là NV-XXX!");
    }
    public static String inputHocVien() {
        return Regex.regexStr(scanner.nextLine(), REGEX_HOCVIEN, "Bạn đã nhập sai mã định danh, mã định danh là HV-XXX!");
    }
    //Kiểm tra Ngày Sinh
    public static boolean isCorrectTypeDate(String date) {
        final String FORMAT_DAY = "^(([0-2]\\d|)|(3)[0-1])/(((0)[1-9])|((1)[0-2]))/(((19)[3-9]\\d)|((20)\\d{2}))$";
        return Pattern.matches(FORMAT_DAY, date);
    }
    public static boolean isBiggerDate(String date1, String date2) {
        return HandleData.converterStringToLocalDate(date1).isAfter(HandleData.converterStringToLocalDate(date2));
    }

}
