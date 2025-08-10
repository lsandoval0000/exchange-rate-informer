package org.abc.exception;

import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import org.jboss.resteasy.reactive.server.UnwrapException;

@UnwrapException({RuntimeException.class})
public class GlobalExceptionMapper {
    @ServerExceptionMapper
    public RestResponse<String> handleRequestLimitExceededException(RequestLimitExceededException exception) {
        return RestResponse.status(Response.Status.BAD_REQUEST, exception.getMessage());
    }

    @ServerExceptionMapper
    public RestResponse<String> handleUserInvalidDateFormatException(InvalidDateFormatException exception) {
        return RestResponse.status(Response.Status.BAD_REQUEST, exception.getMessage());
    }

    @ServerExceptionMapper
    public RestResponse<String> handleInvalidDniException(InvalidDniException exception) {
        return RestResponse.status(Response.Status.BAD_REQUEST, exception.getMessage());
    }
}
