package com.example.demo.experiment;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
@Data
public class DataMeneger {

    private int id;
    private String name;

//    @TransactionRequired
//    public <T extends DataManagerPowerPlantWithEquipmentsListV1> T listWithEquipmentAll(long departmentId, Supplier<T> dtoCreator) throws
//            NotFoundException {
//        List<PowerPlant> powerPlants = findByDepartment(departmentId, identity());
//        T response = dtoCreator.get();
//        response.setItems(
//                powerPlants
//                        .stream()
//                        .map(this::toWithEquipmentItem)
//                        .collect(toList())
//        );
//        return response;
//    }
//
//    @GetMapping("/with-equipments")
//    public DataManagerPowerPlantWithEquipmentsResponse listWithEquipmentAll(
//            @RequestParam(required = false) Long departmentId,
//            ) throws
//            AuthException,
//            ForbiddenException,
//            NotFoundException {
//        requestPrincipal.checkPermission(AuthObject.POWER_PLANT.obj(), "list-with-equipment");
//        return powerPlantManager.listWithEquipmentAll(
//                requestPrincipal.calcDepartmentId(departmentId),
//                DataManagerPowerPlantWithEquipmentsResponse::new
//        );
//    }



}
