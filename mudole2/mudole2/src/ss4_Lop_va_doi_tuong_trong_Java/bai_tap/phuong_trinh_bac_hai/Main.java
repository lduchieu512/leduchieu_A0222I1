package ss4_Lop_va_doi_tuong_trong_Java.bai_tap.phuong_trinh_bac_hai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ax2 + bx + c =0");
        System.out.println("Enter a ");
        double a = scanner.nextDouble();
        System.out.println("Enter b ");
        double b = scanner.nextDouble();
        System.out.println("Enter c ");
        double c = scanner.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);

        System.out.println(quadraticEquation.display());
        System.out.println("delta "+ quadraticEquation.getDiscriminant());
        if (quadraticEquation.getDiscriminant() >0){
            System.out.println("X1 = "+quadraticEquation.getRoot1());
            System.out.println("X2 = "+quadraticEquation.getRoot2());

        }else if(quadraticEquation.getDiscriminant() ==0){
            System.out.println("X1 = "+quadraticEquation.getRoot1());
        }else {
            System.out.println(" The equation has no roots");
        }

    }
}
