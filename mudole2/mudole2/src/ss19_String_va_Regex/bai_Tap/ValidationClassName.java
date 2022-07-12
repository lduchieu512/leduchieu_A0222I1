package ss19_String_va_Regex.bai_Tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationClassName {
    public static void main(String[] args) {
        String regex = "[CAP]\\d{4}\\w*[GHIKLM]";

        String className = "P0318G";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(className);
        System.out.println(className + " is " + matcher.matches());


    }






}
