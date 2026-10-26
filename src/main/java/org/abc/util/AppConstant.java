package org.abc.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class AppConstant {
    public static final String INVALID_DATE_FORMAT_MESSAGE = "Invalid date format for: %s, must be YYYY-MM-DD";
    public static final String REQUEST_LIMIT_EXCEEDED_MESSAGE = "Request limit exceeded";
    public static final String INVALID_DNI_MESSAGE = "Invalid DNI: %s";

    public static final Integer REQUEST_LIMIT = 10;
    
    public static final String MS_NAME = "exchange-rate-informer";
    public static final String QUERY_INFO_PROFILE = "exchange-rate-query";
    public static final String CONSUMER_PROFILE = "exchange-rate-consumer";
}
