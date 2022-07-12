package ss14_Thuat_toan_sap_xep.bai_tap;

import java.util.Arrays;

public class SortAlgorithm {

    public static void main(String[] args) {
        //int[] numbs = {-2, 1, 5, 7, 3, 9, -1, -6, 0, 1};
//        sortInsert(numbs);
        int[] numbs = {32, 1, 59, 18, 12};

        bubbleSort(numbs);
    }

    private static  void selectionSort(){
        
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 1; i <arr.length ; i++) {
            for (int j = 0; j <arr.length-i ; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.printf("Loop %d: ", i + 1);
            display(arr);
            System.out.println();
        }
    }


    private static void sortInsert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int pos = i;
            while (pos > 0 && value < arr[pos - 1]) {
                arr[pos] = arr[pos-1];
                arr[pos-1] = value;
                pos--;
            }
            System.out.printf("Loop %d: ", i);
            display(arr);
            System.out.println();
        }

    }

    private static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}
