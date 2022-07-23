package file_csv;

import models.Genuine;
import services.AddGenuine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    public static void write(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\QuanLiDienThoai\\src\\file_csv\\mobi"));
            for (Genuine g : AddGenuine.genuineList
                 ) {
                writer.write(String.valueOf(g));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
