package ss13_Thuat_toan_tim_kiem.option.bai_tap.tim_chuoi_lien_tiep_co_do_dai_lon_nhat;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StringSequenceMaxLength {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        System.out.println("nhap chuoi: ");
        String string = input.nextLine();

        for (int i = 0; i < string.length(); i++) { //abcabcdgabmnsxy
            if (list.size() > 0 && string.charAt(i) <= list.getLast() && list.contains(string.charAt(i))) {
                list.clear();
            }

            list.add(string.charAt(i));
            System.out.println(list);
                                        //[a,b,c,d,]
            if (list.size()>max.size()){
                max.clear();
                max.addAll(list);//[a,b,c.d]
                System.out.println(max);
            }
            System.out.println(max);
        }
//        for (Character ch: max
//             ) {
//            System.out.println(ch);
//        }
//        System.out.println();
    }

}
