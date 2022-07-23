package BenhVien.Uliti;



import BenhVien.Model.BenhAn;
import BenhVien.Model.BenhAnThuong;
import BenhVien.Model.BenhAnVip;

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
                    if (e instanceof BenhAnThuong) {
                        bufferedWriter.write(((BenhAnThuong) e).getDataBA());
                        bufferedWriter.newLine();
                    }
                    if (e instanceof BenhAnVip) {
                        bufferedWriter.write(((BenhAnVip) e).getDataBA());
                        bufferedWriter.newLine();
                    }
                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static List<BenhAn> readFileBA(String pathFile) {
            List<BenhAn> list = new LinkedList<>();
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
                    if (array.length == 7) {
                            list.add(new BenhAnThuong(array[0], array[1], array[2], array[3],
                                    array[4], array[5], (array[6])));
                    }
                    if (array.length ==8){
                            list.add(new BenhAnVip(array[0], array[1], array[2], array[3],
                                    array[4], array[5], array[6],array[7]));
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

