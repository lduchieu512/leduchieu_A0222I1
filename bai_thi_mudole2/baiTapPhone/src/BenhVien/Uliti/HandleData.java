package BenhVien.Uliti;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HandleData {
    public static LocalDate converterStringToLocalDate(String date){
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatters);
    }

    public static String converterLocalDateToString (LocalDate date){
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatters);
    }
}
