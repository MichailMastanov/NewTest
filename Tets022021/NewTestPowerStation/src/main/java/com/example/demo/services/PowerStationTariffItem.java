package com.example.demo.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PowerStationTariffItem {
    /**
     * ИД станции
     */
    private long id;
    /**
     * КПО станции
     */
    private String kpo;
    /**
     * Тариф
     */
    private double tariff;
}