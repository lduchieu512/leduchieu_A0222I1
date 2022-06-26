package ss14_Thuat_toan_sap_xep.bai_tap;

public class InsertionSort {

    static int[] arr = {3, 5, 8, 2, 6, 9, 4, 1, 10};

    public static void main(String[] args) {
        insertionSort(arr);
    }

    public static void insertionSort(int[] array) {
        System.out.println("Array before:");

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ",array[i]);
        }

        int pos, x;

        int count = 0;
        for (int i = 1; i < array.length; i++) {
            boolean flag = false;
            x = array[i];
            pos = i;
            while (pos > 0 && x < array[pos - 1]) {
                flag = true;

                System.out.print("\nSwap " + array[pos] + " to " + array[pos-1]);
                array[pos] = array[pos - 1];
                array[pos-1] = x;
                pos--;
            }

            if (flag) {
                count++;
                System.out.println("\nArray after " + count + " time sort:");
                for (int element : array) {
                    System.out.printf("%d ", element);
                }
            }
        }
    }
}
