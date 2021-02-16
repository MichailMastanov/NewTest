package com.example.demo.services;

import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EnergyImpl {

    public static Cell findCellByStringValue(Workbook wb, String value) {
        Cell targetCell = null;
        loop:
        for (Sheet sheet : wb) {
            for (int i=0; i<10; i++) {
                Row row = sheet.getRow(i);
                if (row!=null) {
                    for (Cell cell : row) {
                        if (cell.getCellType().equals(CellType.STRING) && cell.getStringCellValue().equals(value)) {
                            targetCell = cell;
                            break loop;
                        }
                    }
                }
            }
        }
        return targetCell;
    }


    public  static PowerStationTariff getTarifTest(Workbook wb) throws Exception {
        PowerStationTariff powerStationTariff = new PowerStationTariff();
        List<PowerStationTariffItem> items = new ArrayList<>();
        List<String> fatalErrors = new ArrayList<>();
        List<String> absentInSaper = new ArrayList<>();
        List<String> absentInFile = new ArrayList<>();
        List<String> absentTariff = new ArrayList<>();
        int kpoIndex, trfIndex, rowIndex;

        Cell kpoCell = findCellByStringValue(wb,"kpo");
        Cell trfCell = findCellByStringValue(wb,"trf");

        if(kpoCell == null || trfCell == null){
            fatalErrors.add("Не корректный формат макета!");
            powerStationTariff.setFatalErrors(fatalErrors);
            return powerStationTariff;
        }

        kpoIndex = kpoCell.getColumnIndex();
        trfIndex = trfCell.getColumnIndex();
        rowIndex = kpoCell.getRowIndex();

        System.out.println(kpoIndex + " " + trfIndex + " " + rowIndex);

        for(Row row: kpoCell.getSheet()){
            if (row.getRowNum() == rowIndex) {
                continue;
            }
            Cell kpo = row.getCell(kpoIndex);
            Cell trf = row.getCell(trfIndex);

            if(kpo != null && kpo.getCellType().equals(CellType.NUMERIC)
                    && kpo.getNumericCellValue() % 1 == 0){

                double objectTariff = 0.0;
                if(trf != null){
                    if(!trf.getCellType().equals(CellType.NUMERIC)
                            || (trf.getCellType().equals(CellType.NUMERIC) && trf.getNumericCellValue() < 0)){
                        fatalErrors.add(String.format("Не допустимый формат данных в столбце %s строка %s.",
                                row.getRowNum() + 1,
                                trfIndex + 1));
                        powerStationTariff.setFatalErrors(fatalErrors);
                        return powerStationTariff;
                    }if(trf.getNumericCellValue() > 0.0){
                        objectTariff = trf.getNumericCellValue();
                    }
                }

                    PowerStationTariffItem powerStationTariffItem = new PowerStationTariffItem();

                    String objectKpo = String.valueOf((int)kpo.getNumericCellValue());


                    System.out.println(objectKpo + " " + objectTariff);

                } else{
                fatalErrors.add(String.format("Не допустимый формат данных в столбце %s строка %s",
                        row.getRowNum() + 1,
                        trfIndex + 1));
                powerStationTariff.setFatalErrors(fatalErrors);
                return powerStationTariff;
                }
            }
        return powerStationTariff;
    }


}
