package com.example.demo.Testing;

import org.apache.poi.ss.usermodel.*;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class TetsTask2 {

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

    public static void getTest(Workbook workbook){
        Cell cellUsl = findCellByStringValue(workbook, "usl");
        Cell cellDate1 = findCellByStringValue(workbook, "date1");
        Cell cellDate2 = findCellByStringValue(workbook, "date2");
        Cell cellDate3 = findCellByStringValue(workbook, "date3");
        Cell cellDate4 = findCellByStringValue(workbook, "date4");
        int date1Index, date2Index, date3Index, date4Index, uslIndex, rowStartIndex;
        date1Index = cellDate1.getColumnIndex();
        date2Index = cellDate2.getColumnIndex();
        date3Index = cellDate3.getColumnIndex();
        date4Index = cellDate4.getColumnIndex();
        uslIndex = cellUsl.getColumnIndex();
        rowStartIndex = cellUsl.getRowIndex();
        for(Row row : cellUsl.getSheet()) {

            if (row.getRowNum() == rowStartIndex) continue;


            //   основная проверка полей
            System.out.println("----------------------------------------------------------------------------");

            String aaa = row.getCell(date3Index).getLocalDateTimeCellValue().toLocalDate().toString();
            String bbb = row.getCell(date4Index).getLocalDateTimeCellValue().toLocalDate().toString();

            LocalDate date1 = LocalDate.parse(aaa, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate date2 = LocalDate.parse(bbb, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            date1.format(DateTimeFormatter.ofPattern("dd.MM.yyyy", new Locale("ru")));
            date2.format(DateTimeFormatter.ofPattern("dd.MM.yyyy", new Locale("ru")));
            System.out.println(date1 + " " + date2);
            System.out.println(date1.compareTo(date2));
            System.out.println("----------------------------------------------------------------------------");


//            String zzz = Collections.reverse(Arrays.asList(bbb)).stream().collect(Collectors.joining("."));
//            System.out.println(zzz);
//            System.out.println(Arrays.toString(bbb));
//            System.out.println(row.getCell(date3Index).getLocalDateTimeCellValue().toLocalDate() + " ");
//
//            System.out.print(row.getCell(date4Index).getCellType() + " ");
//            System.out.print(row.getCell(date4Index).getNumericCellValue() + " ");
//            System.out.print(row.getCell(date4Index).toString() + "    ");
//            System.out.println("");

//            if (row.getCell(date1Index) == null || !row.getCell(date1Index).getCellType().equals(CellType.NUMERIC)
//                    || row.getCell(date2Index) == null || !row.getCell(date2Index).getCellType().equals(CellType.NUMERIC)) {
//                System.out.println("В файле нет данных за указанный период!1");
//            }
//            if (!isValid(row.getCell(date1Index).getStringCellValue())
//                    || !isValid(row.getCell(date2Index).getStringCellValue())) {
//                System.out.println("В файле нет данных за указанный период!2");
//
//            }
//            if(row.getCell(powerPlantNameIndex) == null || !row.getCell(powerPlantNameIndex).getCellType().equals(CellType.STRING)){
//                System.out.println("Для %s строки в файле-макете не найдено совпадений с данными САПЭРа.")
//                continue;
//            }
        }
    }

//    static boolean isBoolean(String text){
//        return text.matches("[0-3]\\d-[янв||февр||мар||апр||мая||июн||июл||авг||сент||окт||нояб||дек]-\\d{2}}");
//    }

    static boolean isBoolean(String text){
        return text.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    //             return text.matches("[0-3]\\d-[янв\\., февр\\., мар\\., апр\\., мая, июн\\., июл\\., авг\\., сент\\., окт\\., нояб\\., дек\\.]\\d-\\d{4}}");

    //   проверка валидности формата даты
    static boolean isValid(String text) {
        if (!text.matches("[12]\\d{3}-[01]\\-[0-3]\\d"))
            return false;
        String[] bbb = text.split("-");
        String startStr = bbb[2];
            bbb [2] = bbb [0];
            bbb[0] = startStr;
            String zzz = Arrays.stream(bbb).collect(Collectors.joining("."));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(zzz);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }


}
