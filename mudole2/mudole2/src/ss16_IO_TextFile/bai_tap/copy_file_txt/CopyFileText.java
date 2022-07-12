package ss16_IO_TextFile.bai_tap.copy_file_txt;

import java.io.*;

public class CopyFileText {

    static final String PATH = "F:\\codegym_A0222I1_LE_DUC_HIEU\\mudole2\\mudole2\\src\\ss16_IO_TextFile\\bai_tap\\copy_file_txt";

    public static void main(String[] args) {
        String source = PATH + "\\test.csv.txt";
        String des = PATH + "\\test_copy.txt";
        try {
            copyFile(source, des);
            writeNumberCharacter(des);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }


    private static void copyFile(String source, String des) throws IOException {
        FileInputStream sourceFile = new FileInputStream(source);
        FileOutputStream destFile = new FileOutputStream(des);
        byte[] array = new byte[1024];
        sourceFile.read(array);
        destFile.write(array);
        sourceFile.close();
        destFile.close();
    }

    private static void writeNumberCharacter(String path) throws IOException {
        File file = new File(path);
        if (!file.canRead())
            file.setReadable(true);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        String tmp = "";
        while ((line = bufferedReader.readLine()) != null) {
            tmp += line;
        }
        bufferedReader.close();

        int res = tmp.replace(" ", "").length();
        System.out.println(res);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        bufferedWriter.write("\nTotal charter in file: " + res);
        bufferedReader.close();


    }


}
