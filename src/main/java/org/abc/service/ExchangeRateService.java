package org.abc.service;

import org.abc.dto.ExchangeRateDto;

import java.util.List;

public interface ExchangeRateService {
    ExchangeRateDto getExchangeRate(String dni);
    List<ExchangeRateDto> getExchangeRateRequestsByUser(String dni, String date);
}
