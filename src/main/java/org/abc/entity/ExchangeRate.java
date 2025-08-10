package org.abc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "exchange_rate", schema = "abc_bank")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRate {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dni")
    private String dni;
    @Column(name = "report_date")
    private String reportDate;
    @Column(name = "sunat_value")
    private double sunatValue;
    @Column(name = "buy_price")
    private double buyPrice;
    @Column(name = "sell_price")
    private double sellPrice;
    @Column(name = "request_date")
    private String requestDate;
}
