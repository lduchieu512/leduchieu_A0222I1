package ss5_Access_modifier_and_static_method_and_static_property.bai_tap.student;

public class Student {
    private String name ="John";
    private String classes = "A02";


    public Student(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
