package org.abc.service.impl;

import static org.abc.util.AppConstant.REQUEST_LIMIT;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import java.util.List;
import org.abc.entity.ExchangeRate;
import org.abc.exception.RequestLimitExceededException;
import org.abc.mapper.ExchangeRateMapper;
import org.abc.repository.ExchangeRateRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


@QuarkusTest
class ExchangeRateServiceImplTest {

    @Inject
    ExchangeRateServiceImpl exchangeRateService;

    @InjectMock
    ExchangeRateRepository exchangeRateRepository;
    
    @InjectMock
    ExchangeRateMapper exchangeRateMapper;

    @Test
    @DisplayName("Should return error message when request limit exceeded for exchange rate request")
    void shouldReturnErrorMessageWhenRequestLimitExceededForExchangeRateRequest() {
        List<ExchangeRate> exchangeRateList = Mockito.mock(List.class);
        when(exchangeRateList.size()).thenReturn(REQUEST_LIMIT);
        when(exchangeRateRepository.findByDniAndRequestDate(anyString(), anyString()))
                .thenReturn(exchangeRateList);
        assertThrows(RequestLimitExceededException.class,
                () -> exchangeRateService.getExchangeRate("00000000"));
    }
}