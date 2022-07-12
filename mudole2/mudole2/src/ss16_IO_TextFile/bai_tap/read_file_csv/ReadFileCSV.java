package ss16_IO_TextFile.bai_tap.read_file_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileCSV {
    private static final String path = "src\\ss16_IO_TextFile\\bai_tap\\read_file_csv\\text.csv";

    public static void main(String[] args) {
        try{
            readCSV(path);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readCSV(String source) throws IOException {
        BufferedReader bf= new BufferedReader(new FileReader(path));
        String line="";
        while ((line=bf.readLine())!=null){
            String[] country = line.split("");
            System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
        }
    }


}
