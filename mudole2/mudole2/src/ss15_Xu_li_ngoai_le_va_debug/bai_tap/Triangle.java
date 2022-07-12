package ss15_Xu_li_ngoai_le_va_debug.bai_tap;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int a,b,c;
        System.out.println("Please enter 3 side of triangle!");
        System.out.println("Enter a");
        a = scanner.nextInt();
        System.out.println("Enter b");
        b = scanner.nextInt();
        System.out.println("Enter c");
        c = scanner.nextInt();

        try{
            Triangle.checkTriangle(a,b,c);
            System.out.println(" Perfect Triangle ");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void checkTriangle(int slide1,int slide2,int slide3) throws Exception{
        if (slide1 +slide2 <slide3|| slide1 +slide3 <slide2||slide2+slide3<slide1){
            throw new Exception("Sum of two edge must be bigger than remaining edge!");
        }
        if (slide1<= 0|| slide2<=0||slide3<=3){
            throw new Exception("Edge must be bigger than zero!");
        }
    }


}
