package org.abc.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {
    public static boolean isValidFormatAndDate(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
            return true;
        } catch (RuntimeException exception) {
            return false;
        }
    }

    public static String getActualDate() {
        return LocalDate.now(ZoneId.of("America/Lima")).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
