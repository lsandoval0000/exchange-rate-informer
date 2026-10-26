package org.abc.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.abc.proxy.AuthServiceRestClient;
import org.abc.proxy.model.TokenRequestProxyModel;
import org.abc.proxy.model.TokenResponseProxyModel;
import org.abc.service.TokenConsumerService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class TokenConsumerServiceImpl implements TokenConsumerService {
    private final AuthServiceRestClient authServiceRestClient;

    public TokenConsumerServiceImpl(@RestClient AuthServiceRestClient authServiceRestClient) {
        this.authServiceRestClient = authServiceRestClient;
    }

    @Override
    public TokenResponseProxyModel getTokenResponse(TokenRequestProxyModel tokenRequest) {
        Response response = authServiceRestClient.generateToken(tokenRequest);
        return response.readEntity(TokenResponseProxyModel.class);
    }
}
