package org.abc.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DniUtil {
    public static boolean isValidDni(String dni) {
        return !Objects.isNull(dni) && dni.length() == 8;
    }
}
