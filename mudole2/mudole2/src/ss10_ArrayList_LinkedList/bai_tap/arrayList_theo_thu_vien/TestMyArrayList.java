package ss10_ArrayList_LinkedList.bai_tap.arrayList_theo_thu_vien;

public class TestMyArrayList {
    public static class Student{
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student a = new Student(1,"Huy");
        Student b = new Student(2,"Hiệu");
        Student c = new Student(3,"Hiệp");
        Student d = new Student(4,"Hạnh");
        Student e = new Student(5,"Hưng");
        Student f = new Student(5,"Hậu");

        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();
        MyArrayList<Student> newMyArrayList = new MyArrayList<>();
        studentMyArrayList.add(a);
        studentMyArrayList.add(b);
        studentMyArrayList.add(c);
        studentMyArrayList.add(d);
        studentMyArrayList.add(e);
       // studentMyArrayList.add(f,2);
        studentMyArrayList.size();


//        System.out.println(studentMyArrayList.size());
//
//        System.out.println(studentMyArrayList.get(2).getName());

//        System.out.println(studentMyArrayList.indexOf(f));
      //  System.out.println(studentMyArrayList.contains(a));
        newMyArrayList = studentMyArrayList.clone();
       Student student = newMyArrayList.remove(1);
   //    System.out.println(student.getName());
        for (int i = 0; i < newMyArrayList.size(); i++) {
            System.out.println(newMyArrayList.get(i).getName());
        }


    }


}
