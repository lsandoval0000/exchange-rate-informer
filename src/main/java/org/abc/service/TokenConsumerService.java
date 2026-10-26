package org.abc.service;

import org.abc.proxy.model.TokenRequestProxyModel;
import org.abc.proxy.model.TokenResponseProxyModel;

public interface TokenConsumerService {
    TokenResponseProxyModel getTokenResponse(TokenRequestProxyModel tokenRequest);
}
