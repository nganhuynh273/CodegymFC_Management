package hpn.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class InstantUtils {
    private static final String DATE_PATTERN = "dd-MM-yyyy";

    public static String instantToFormat(Instant instant) {
        return instantToFormat(instant, null);
    }

    public static String instantToFormat(Instant instant, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern == null ? DATE_PATTERN : pattern)
                .withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }
    public static String instantToString(Instant instant) {
        return instantToString(instant, null);
    }

    public static String instantToString(Instant instant, String patternFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternFormat != null ? patternFormat : DATE_PATTERN).withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

    public static long currentTimeSecond() {
        return System.currentTimeMillis() / 1000;
    }
}
