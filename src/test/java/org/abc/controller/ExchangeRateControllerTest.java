package org.abc.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@QuarkusTest
class ExchangeRateControllerTest {
    @ParameterizedTest
    @ValueSource(strings = {"12345678", "87654321"})
    @DisplayName("Should return exchange rate values when request is valid")
    @TestTransaction
    void shouldReturnExchangeRateValuesWhenRequestIsValid(String dni) {
        var currentDate = LocalDate.now().toString();
        given()
                .when().get("/api/exchange-rate/get-exchange-rate?dni=" + dni)
                .then()
                .statusCode(200)
                .body(containsString(currentDate),
                        containsString(dni));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", ""})
    @DisplayName("Should return error message when dni on exchange rate request is not valid")
    @TestTransaction
    void shouldReturnErrorMessageWhenDniOnExchangeRateRequestIsNotValid(String dni) {
        given()
                .when().get("/api/exchange-rate/get-exchange-rate?dni=" + dni)
                .then()
                .statusCode(400)
                .body(containsString("Invalid DNI"));
    }

    @Test
    @DisplayName("Should return requests made by user when request is valid")
    void shouldReturnRequestsMadeByUserWhenRequestIsValid() {
        String requestDate = "2025-08-09";
        String dni = "47081541";
        given()
                .when().get("/api/exchange-rate/get-requests-by-user?dni=" + dni + "&requestDate=" + requestDate)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Should return error message when request date is not valid")
    void shouldReturnErrorMessageWhenRequestDateIsNotValid() {
        String requestDate = "10-08-2025";
        String dni = "47081541";
        given()
                .when().get("/api/exchange-rate/get-requests-by-user?dni=" + dni + "&requestDate=" + requestDate)
                .then()
                .statusCode(400)
                .body(containsString("Invalid date format"));
    }
}