package org.abc.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.abc.exception.InvalidDateFormatException;
import org.abc.exception.InvalidDniException;

import static org.abc.util.AppConstant.INVALID_DATE_FORMAT_MESSAGE;
import static org.abc.util.AppConstant.INVALID_DNI_MESSAGE;
import static org.abc.util.DateUtil.isValidFormatAndDate;
import static org.abc.util.DniUtil.isValidDni;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExchangeRateRequestUtil {
    public static void validateExchangeRateRequest(String dni, String date) {
        if(!isValidFormatAndDate(date))
            throw new InvalidDateFormatException(
                    String.format(INVALID_DATE_FORMAT_MESSAGE, date));
        if(!isValidDni(dni))
            throw new InvalidDniException(String.format(INVALID_DNI_MESSAGE, dni));
    }
}
