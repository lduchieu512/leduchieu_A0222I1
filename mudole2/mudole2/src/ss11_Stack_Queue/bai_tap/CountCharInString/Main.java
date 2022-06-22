package ss11_Stack_Queue.bai_tap.CountCharInString;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String stTest = "Hello Bro!";
            TreeMap<Character,Integer> treeMap = new TreeMap<>();
        Arrays.asList(stTest.toUpperCase().split("")).forEach(e->{
            int count =1;
            if (treeMap.containsKey(e.charAt(0))){
                count+= treeMap.get(e.charAt(0));
            }

            treeMap.put(e.charAt(0),count);
        });
        for (Map.Entry<Character,Integer> s: treeMap.entrySet()
             ) {
            System.out.println(s);

        }
    }
}
