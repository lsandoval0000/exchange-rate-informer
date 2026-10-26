package org.abc.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.abc.dto.ExchangeRateDto;
import org.abc.service.ExchangeRateService;

import static org.abc.util.AppConstant.CONSUMER_PROFILE;
import static org.abc.util.AppConstant.QUERY_INFO_PROFILE;


@Path("exchange-rate")
@RequiredArgsConstructor
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @Path("get-exchange-rate")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed(CONSUMER_PROFILE)
    public Response getExchangeRate(@QueryParam("dni") String dni) {
        ExchangeRateDto exchangeRate = exchangeRateService.getExchangeRate(dni);
        return Response.ok(exchangeRate).build();
    }

    @Path("get-requests-by-user")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed(QUERY_INFO_PROFILE)
    public Response getExchangeRateRequestsByUser(
            @QueryParam("dni") String dni, @QueryParam("requestDate") String requestDate) {
        List<ExchangeRateDto> exchangeRateList = exchangeRateService.getExchangeRateRequestsByUser(dni, requestDate);
        return Response.ok(exchangeRateList).build();
    }
}
