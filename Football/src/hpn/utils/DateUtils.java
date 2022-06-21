package hpn.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.regex.Pattern;

public class DateUtils {
    public static final String DATE_PATTERN = "dd-MM-yyyy";
    public static final String DATE_PATTERN_2 = "E MMM dd HH:mm:ss Z yyyy";

    private static final String DATE_PATTERN_REGEX = "^\\d{2}-(\\d){2}-(\\d){4}$";

    public static String dateToString(Date date, String pattern) {
        DateFormat simpleDateFormat = new SimpleDateFormat(pattern == null ? DATE_PATTERN : pattern);
        simpleDateFormat.setLenient(false);
        return simpleDateFormat.format(date);
    }

    // boolean >> truong add
    public static boolean isDateToString(String pattern) {
       return Pattern.matches(DATE_PATTERN_REGEX, pattern);
    }

    public static String dateToString(Date date) {
        return dateToString(date, null);
    }

    public static Date stringToDate(String dateString, String pattern) {
        DateFormat simpleDateFormat = new SimpleDateFormat(pattern == null ? DATE_PATTERN_2 : pattern);
        try {
            simpleDateFormat.setLenient(false);
            return simpleDateFormat.parse(dateString.trim());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static Date stringToDate(String dateString) {
        return stringToDate(dateString, null);
    }

    public static long currentTimeSecond() {
        return System.currentTimeMillis() / 1000;
    }


}
