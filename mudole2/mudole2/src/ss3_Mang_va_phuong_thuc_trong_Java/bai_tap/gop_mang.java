package ss3_Mang_va_phuong_thuc_trong_Java.bai_tap;

public class gop_mang {
    public static void main(String[] args) {
        int []arr1 ={1,2,3,4,5,6,7,8};
        int []arr2 ={9,10,11,12,13,14,15};
        int length1 = arr1.length;
        int length2 = arr2.length;
        int [] arr3 = new int[length1+length2];
        for (int i = 0; i <arr1.length ; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = 0; i <arr2.length ; i++) {
            arr3[length1+i]= arr2[i];
        }
        for (int i = 0; i <arr3.length ; i++) {
            System.out.print(arr3[i] +"\t");
        }

    }
}
