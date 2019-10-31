package distribution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static double returnDouble(String s) {
        return s.isEmpty() ? 0.0 : Double.parseDouble(s);
    }

    public static int returnInteger(String s) {
        return s.isEmpty() ? 0 : Integer.parseInt(s);
    }

    public static Character getChar0(String s) {
        return (s.isEmpty() || s.equals(" ")) ? null : s.charAt(0);
    }

    public static LocalTime getTimeS(String s) {
        return LocalTime.parse(s, DateTimeFormatter.ofPattern("HHmmss.SSS"));
    }

    public static LocalTime getTime(String s) {
        return LocalTime.parse(s, DateTimeFormatter.ofPattern("HHmmss"));
    }

    public static LocalTime getTimeSS(String s) {
        return LocalTime.parse(s, DateTimeFormatter.ofPattern("HHmmss.SS"));
    }

    public static LocalDate getDate(String s) {
        return LocalDate.parse(s, DateTimeFormatter.ofPattern("ddMMyy"));
    }

    public static void print(String s){
        System.out.println(s);
    }
}
