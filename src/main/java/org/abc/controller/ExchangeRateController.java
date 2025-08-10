package org.abc.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.abc.dto.ExchangeRateDto;
import org.abc.service.ExchangeRateService;


@Path("exchange-rate")
@RequiredArgsConstructor
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @Path("get-exchange-rate")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExchangeRate(@QueryParam("dni") String dni) {
        ExchangeRateDto exchangeRate = exchangeRateService.getExchangeRate(dni);
        return Response.ok(exchangeRate).build();
    }

    @Path("get-requests-by-user")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExchangeRateRequestsByUser(
            @QueryParam("dni") String dni, @QueryParam("requestDate") String requestDate) {
        List<ExchangeRateDto> exchangeRateList = exchangeRateService.getExchangeRateRequestsByUser(dni, requestDate);
        return Response.ok(exchangeRateList).build();
    }
}
