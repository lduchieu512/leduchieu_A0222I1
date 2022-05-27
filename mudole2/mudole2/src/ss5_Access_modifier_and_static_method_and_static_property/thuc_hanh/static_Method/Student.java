package ss5_Access_modifier_and_static_method_and_static_property.thuc_hanh.static_Method;

public class Student {
    private int rollo;
    private String name;
    private static String college ="BBDIT";

    //constructor to initialize the variable
    Student(int r,String n){
        rollo =r;
        name =n;
    }
    //static method to change the value of static variable
    static void change(){
        college ="CODEGYM";
    }
    //method to display values
    void display(){
        System.out.println( rollo+" " +name+" "+college);
    }




}
