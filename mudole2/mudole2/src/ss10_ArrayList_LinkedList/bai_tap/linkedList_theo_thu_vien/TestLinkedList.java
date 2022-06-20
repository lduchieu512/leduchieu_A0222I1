package ss10_ArrayList_LinkedList.bai_tap.linkedList_theo_thu_vien;

public class TestLinkedList {
    public static void main(String[] args) {
        class Student {
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

        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1,"Nam");
        Student student2 = new Student(2,"Tai");
        Student student3 = new Student(3,"Huy");
        Student student4 = new Student(4,"Hieu");
        Student student5 = new Student(5,"Trung");
        Student student6 = new Student(6,"Trung");

        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addLast(student3);
        myLinkedList.add(2,student5);
        myLinkedList.add(3,student4);

       // myLinkedList.remove(0);
        // myLinkedList.remove(student5);


//        for (int i = 0; i <myLinkedList.size() ; i++) {
//            Student student = (Student) myLinkedList.get(i);
//            System.out.print(student.getId());
//            System.out.println(student.getName());
//        }


//        MyLinkedList<Student> cloneLinkedList = myLinkedList.clone();
//        for (int i = 0; i <cloneLinkedList.size() ; i++) {
//            Student student = (Student) cloneLinkedList.get(i);
//            System.out.print(student.getId());
//            System.out.println(student.getName());
//        }


//        System.out.println(myLinkedList.constrains(student6));

        System.out.println(myLinkedList.indexOf(student6));


    }
}
