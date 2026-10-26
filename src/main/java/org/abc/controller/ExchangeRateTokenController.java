package org.abc.controller;

import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.abc.proxy.model.TokenRequestProxyModel;
import org.abc.service.TokenConsumerService;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import static org.abc.util.AppConstant.*;

@Path("tokens")
@RequiredArgsConstructor
public class ExchangeRateTokenController {
    private final TokenConsumerService tokenConsumerService;

    @ConfigProperty(name = "app.ms.identifier")
    String msIdentifier;                       // non-final by design — CDI field injection

    @Path("get-consumer-token")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getConsumerToken() {
        TokenRequestProxyModel request = new TokenRequestProxyModel();
        request.setMsIdentifier(msIdentifier);
        request.setMsName(MS_NAME);
        request.setProfile(CONSUMER_PROFILE);
        return Response.ok(tokenConsumerService.getTokenResponse(request)).build();
    }
    
    @Path("get-query-token")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getQueryToken() {
        TokenRequestProxyModel request = new TokenRequestProxyModel();
        request.setMsIdentifier(msIdentifier);
        request.setMsName(MS_NAME);
        request.setProfile(QUERY_INFO_PROFILE);
        return Response.ok(tokenConsumerService.getTokenResponse(request)).build();
    }
}
