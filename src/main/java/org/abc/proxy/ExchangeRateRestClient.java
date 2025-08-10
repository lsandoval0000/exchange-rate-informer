package org.abc.proxy;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.rest.client.reactive.jackson.ClientObjectMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.abc.proxy.model.ExchangeRateProxyModel;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("tipo-cambio")
@RegisterRestClient(configKey = "exchange-rate-api")
public interface ExchangeRateRestClient {
    @GET
    @Path("{date}.json")
    @Produces(MediaType.APPLICATION_JSON)
    ExchangeRateProxyModel getExchangeRate(@PathParam("date") String date);

    @ClientObjectMapper
    static ObjectMapper objectMapper(ObjectMapper defaultObjectMapper) {
        return defaultObjectMapper.copy()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(DeserializationFeature.UNWRAP_ROOT_VALUE);
    }
}
