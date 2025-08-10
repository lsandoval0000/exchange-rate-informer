package org.abc.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.abc.entity.ExchangeRate;


@ApplicationScoped
public class ExchangeRateRepository implements PanacheRepository<ExchangeRate> {

    public List<ExchangeRate> findByDniAndRequestDate(String dni, String requestDate) {
        return list("dni = :dni and requestDate = :requestDate",
                Parameters.with("dni", dni)
                        .and("requestDate", requestDate));
    }
}
