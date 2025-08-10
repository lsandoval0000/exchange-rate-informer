package org.abc.mapper;

import org.abc.dto.ExchangeRateDto;
import org.abc.entity.ExchangeRate;
import org.abc.proxy.model.ExchangeRateProxyModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExchangeRateMapper {
    ExchangeRateMapper INSTANCE = Mappers.getMapper(ExchangeRateMapper.class);

    @Mapping(target = "sunatValue", source = "sunat")
    @Mapping(target = "buyPrice", source = "compra")
    @Mapping(target = "sellPrice", source = "venta")
    @Mapping(target = "reportDate", source = "fecha")
    ExchangeRateDto toExchangeRateDtoFromProxy(ExchangeRateProxyModel exchangeRateProxy);

    @Mapping(target = "sunatValue", source = "sunat")
    @Mapping(target = "buyPrice", source = "compra")
    @Mapping(target = "sellPrice", source = "venta")
    @Mapping(target = "reportDate", source = "fecha")
    ExchangeRate toExchangeRateEntityFromProxy(ExchangeRateProxyModel exchangeRateProxy);

    ExchangeRateDto toExchangeRateDtoFromEntity(ExchangeRate exchangeRate);

    List<ExchangeRateDto> toExchangeRateDtoListFromEntityList(List<ExchangeRate> exchangeRateList);
}
