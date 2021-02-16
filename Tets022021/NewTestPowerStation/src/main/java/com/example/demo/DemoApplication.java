package com.example.demo;

import com.example.demo.Testing.Phone;
import com.example.demo.Testing.TetsTask2;
import com.example.demo.experiment.DataMeneger;
import com.example.demo.experiment.PPSupe;
import com.example.demo.inicialisation.Zoo;
import com.example.demo.services.EnergyImpl;
import com.example.demo.services.PowerStationTariff;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);

        Zoo zoo = new Zoo();

         //   test Book   ----------------------------------------------------------------------------------------

        System.out.println("Все работает!") ;
        System.out.println("Качаем файл и создаем книгу!") ;

        Workbook wb = WorkbookFactory.create(new File("C:\\Users\\михаил\\IdeaProjects\\TestExel\\src\\main\\resources\\powerPlantQuipment.xlsx"));
        System.out.println("Книга создана!");

        System.out.println("___________________________________________________________________________");


    }

}
