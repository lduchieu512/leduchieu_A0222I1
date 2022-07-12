package ss19_String_va_Regex.bai_Tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationPhone {

    public static void main(String[] args) {
        String regex = "\\(\\d{2}\\)-\\(0\\d{9}\\)";
        String phone = "(a8)-(22222222)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        System.out.println(phone+ " is "+ matcher.matches());

    }

}
