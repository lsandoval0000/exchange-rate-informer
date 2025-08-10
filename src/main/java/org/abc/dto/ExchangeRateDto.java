package org.abc.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RegisterForReflection
public class ExchangeRateDto {
    private String dni;
    private String reportDate;
    private double sunatValue;
    private double buyPrice;
    private double sellPrice;
    private String requestDate;
}
