package ss4_Lop_va_doi_tuong_trong_Java.bai_tap.phuong_trinh_bac_hai;

public class QuadraticEquation {
    double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return (this.b * this.b - 4 * this.a * this.c) ;
    }

    public double getRoot1() {
        return ((-this.b + Math.sqrt(getDiscriminant())) /( this.a * 2));
    }

    public double getRoot2() {
        return ((-this.b - Math.sqrt(getDiscriminant())) /( this.a * 2));
    }

    public String display() {
        return a + "x2 + " + b + "x +" + c + " =0";
    }

}
