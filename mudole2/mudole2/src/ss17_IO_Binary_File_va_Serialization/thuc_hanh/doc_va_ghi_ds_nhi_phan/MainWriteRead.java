package ss17_IO_Binary_File_va_Serialization.thuc_hanh.doc_va_ghi_ds_nhi_phan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainWriteRead {
    public static void writeToFile(String path, List<Student> students)throws IOException{
        try {
            FileOutputStream fos =new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return students;
    }
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        try {
            writeToFile("F:\\codegym_A0222I1_LE_DUC_HIEU\\mudole2\\mudole2\\src\\ss17_IO_Binary_File_va_Serialization\\thuc_hanh\\student.txt",students);
            List<Student> studentDataFromFile = readDataFromFile("F:\\codegym_A0222I1_LE_DUC_HIEU\\mudole2\\mudole2\\src\\ss17_IO_Binary_File_va_Serialization\\thuc_hanh\\student.txt");
            for (Student student :
                    studentDataFromFile) {
                System.out.println(student);
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());

        }




    }

}
