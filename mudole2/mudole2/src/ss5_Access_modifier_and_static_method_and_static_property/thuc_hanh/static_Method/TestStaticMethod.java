package ss5_Access_modifier_and_static_method_and_static_property.thuc_hanh.static_Method;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();
        Student s1 = new Student(111,"Nam");
        Student s2 = new Student(222,"Hải");
        Student s3 = new Student(333, "Hiếu");

        s1.display();
        s2.display();
        s3.display();

    }







}
