package com.example.demo.services;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PowerStationTariff {
    /**
     *  Список балансов
     */
    List<PowerStationTariffItem> items = new ArrayList<>();
    /**
     *  Список фатальных ошибок при вычислении
     */
    private List<String> fatalErrors = new ArrayList<>();
    /**
     *  Отсутствует в ДМ
     */
    private List<String> absentInSaper = new ArrayList<>();
    /**
     *  Отсутствует в файле
     */
    private List<String> absentInFile = new ArrayList<>();
    /**
     *  Отсутствует тариф
     */
    private List<String> absentTariff = new ArrayList<>();
}
