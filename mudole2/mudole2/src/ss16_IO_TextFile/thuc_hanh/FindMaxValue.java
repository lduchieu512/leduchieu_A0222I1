package ss16_IO_TextFile.thuc_hanh;

import java.util.List;

public class FindMaxValue {
    public  static  int findMax(List<Integer> numbers){
        int max = numbers.get(0);
        for (Integer number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("F:\\codegym_A0222I1_LE_DUC_HIEU\\mudole2\\mudole2\\src\\ss16_IO_TextFile\\thuc_hanh\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("F:\\codegym_A0222I1_LE_DUC_HIEU\\mudole2\\mudole2\\src\\ss16_IO_TextFile\\thuc_hanh\\result.txt",maxValue);
    }


}
