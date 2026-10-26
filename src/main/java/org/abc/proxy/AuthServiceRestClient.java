package org.abc.proxy;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.rest.client.reactive.jackson.ClientObjectMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.abc.proxy.model.TokenRequestProxyModel;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/auth")
@RegisterRestClient(configKey = "auth-service-api")
public interface AuthServiceRestClient {
    @POST
    @Path("/token")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response generateToken(TokenRequestProxyModel tokenRequest);

    @POST
    @Path("/refresh")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response refreshToken(
            @HeaderParam("Authorization") String authorizationToken, 
            TokenRequestProxyModel tokenRequest);

    @POST
    @Path("/revoke")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response revokeToken(
            @HeaderParam("Authorization") String authorizationToken, 
            TokenRequestProxyModel tokenRequest);
    
    @ClientObjectMapper
    static ObjectMapper objectMapper(ObjectMapper defaultObjectMapper) {
        return defaultObjectMapper.copy()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(DeserializationFeature.UNWRAP_ROOT_VALUE);
    }
}
