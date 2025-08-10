package org.abc.proxy.model;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@RegisterForReflection
public class ExchangeRateProxyModel {
    private String fecha;
    private double sunat;
    private double compra;
    private double venta;
}
