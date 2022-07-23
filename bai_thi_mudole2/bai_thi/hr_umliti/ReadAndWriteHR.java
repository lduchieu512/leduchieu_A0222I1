package bai_thi.hr_umliti;

import bai_thi.hr_model.Employee;
import bai_thi.hr_model.Human;
import bai_thi.hr_model.Student;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteHR {
    public static <E> void writeHRList(List<E> eList, String pathFile, boolean append) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (E e : eList) {
                if (e instanceof Employee) {
                    bufferedWriter.write(((Employee) e).getHRData());
                    bufferedWriter.newLine();
                }
                if (e instanceof Student) {
                    bufferedWriter.write(((Student) e).getHRData());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Human> readHRList(String pathFile) {
        List<Human> humanList = new LinkedList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        String[] array = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) continue;
                array = line.split(",");
                if (array.length == 8) {
                    if ((array[0].contains("NV"))) {
                        humanList.add(new Employee(array[0], array[1], array[2], array[3],
                                array[4], array[5], array[6], array[7]));
                    } else {
                        humanList.add(new Student(array[0], array[1], array[2], array[3],
                                array[4], array[5], array[6], array[7]));
                    }
                }

            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return humanList;
    }

}

