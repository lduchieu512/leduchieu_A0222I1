package ss13_Thuat_toan_tim_kiem.option.thuc_hanh;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string ");
        String inputString = scanner.nextLine();

        int[] frequentChar = new int[255];
        for (int i = 0; i <inputString.length() ; i++) {
            int ascii = inputString.charAt(i);
            frequentChar[ascii] +=1;
        }

        int max =0;
        char character = 255;
        for (int i = 0; i <255 ; i++) {
            if (frequentChar[i] >max){
                max = frequentChar[i];
                character = (char) i;
            }
        }
        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");


    }


}
