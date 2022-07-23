package Utili;


import Model.HocVien;
import Model.NhanSu;
import Model.NhanVien;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWrite {
    public static <E> void writeList(List<E> eList, String pathFile, boolean append) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (E e : eList) {
                if (e instanceof NhanVien) {
                    bufferedWriter.write(((NhanVien) e).getData());
                    bufferedWriter.newLine();
                }
                if (e instanceof HocVien) {
                    bufferedWriter.write(((HocVien) e).getData());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<NhanSu> readFileBA(String pathFile) {
        List<NhanSu> list = new LinkedList<>();
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
                if (array[6].contains("Đào tạo") || array[6].contains("Tuyển sinh") || array[6].contains("Truyền thông")) {
                    list.add(new NhanVien(array[0], array[1], array[2], array[3],
                            array[4], array[5], array[6], array[7]));
                } else {
                    list.add(new HocVien(array[0], array[1], array[2], array[3],
                            array[4], array[5], array[6], array[7]));
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}

