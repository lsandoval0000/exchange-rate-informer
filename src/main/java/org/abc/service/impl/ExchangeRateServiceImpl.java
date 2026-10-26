package org.abc.service.impl;

import static org.abc.util.AppConstant.*;
import static org.abc.util.DateUtil.getActualDate;
import static org.abc.util.ExchangeRateRequestUtil.validateExchangeRateRequest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import org.abc.dto.ExchangeRateDto;
import org.abc.entity.ExchangeRate;
import org.abc.exception.RequestLimitExceededException;
import org.abc.mapper.ExchangeRateMapper;
import org.abc.proxy.ExchangeRateRestClient;
import org.abc.repository.ExchangeRateRepository;
import org.abc.service.ExchangeRateService;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@ApplicationScoped
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final ExchangeRateRepository exchangeRateRepository;
    private final ExchangeRateRestClient exchangeRateRestClient;
    private final ExchangeRateMapper exchangeRateMapper;

    public ExchangeRateServiceImpl(
            ExchangeRateRepository exchangeRageRepository,
            @RestClient ExchangeRateRestClient exchangeRateRestClient,
            ExchangeRateMapper exchangeRateMapper) {
        this.exchangeRateRepository = exchangeRageRepository;
        this.exchangeRateRestClient = exchangeRateRestClient;
        this.exchangeRateMapper = exchangeRateMapper;
    }

    @Override
    @Transactional
    public ExchangeRateDto getExchangeRate(String dni) {
        String currentDate = getActualDate();
        validateExchangeRateRequest(dni, currentDate);
        List<ExchangeRate> exchangeRateList = exchangeRateRepository.findByDniAndRequestDate(dni, currentDate);
        if(exchangeRateList.size() >= REQUEST_LIMIT)
            throw new RequestLimitExceededException(REQUEST_LIMIT_EXCEEDED_MESSAGE);
        ExchangeRate exchangeRate = exchangeRateMapper
                .toExchangeRateEntityFromProxy(exchangeRateRestClient.getExchangeRate(currentDate));
        exchangeRate.setDni(dni);
        exchangeRate.setRequestDate(currentDate);
        exchangeRateRepository.persist(exchangeRate);
        return exchangeRateMapper.toExchangeRateDtoFromEntity(exchangeRate);
    }

    @Override
    public List<ExchangeRateDto> getExchangeRateRequestsByUser(String dni, String date) {
        validateExchangeRateRequest(dni, date);
        return exchangeRateMapper
                .toExchangeRateDtoListFromEntityList(exchangeRateRepository.findByDniAndRequestDate(dni, date));
    }
}
