package com.example.demo.Testing;

import com.example.demo.experiment.DataMeneger;
import com.example.demo.experiment.PPSupe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CreateMap {

    public CreateMap() {
        List<DataMeneger> units1 = new ArrayList<>();
        List<DataMeneger> units2 = new ArrayList<>();
        List<DataMeneger> units3 = new ArrayList<>();
        List<PPSupe> ppAll = new ArrayList<>();
        PPSupe pp1 = new PPSupe();
        PPSupe pp3 = new PPSupe();
        PPSupe pp2 = new PPSupe();
        DataMeneger un1 = new DataMeneger();
        DataMeneger un2 = new DataMeneger();
        DataMeneger un3 = new DataMeneger();
        DataMeneger un4 = new DataMeneger();
        DataMeneger un5 = new DataMeneger();
        DataMeneger un6 = new DataMeneger();
        DataMeneger un7 = new DataMeneger();
        DataMeneger un8 = new DataMeneger();
        un1.setId(1);
        un2.setId(2);
        un3.setId(3);
        un4.setId(1);
        un5.setId(2);
        un6.setId(2);
        un7.setId(3);
        un1.setName("truba");
        un2.setName("kotel");
        un3.setName("provod");
        un4.setName("rere");
        un5.setName("qwqw");
        un6.setName("kotel");
        un7.setName("provod");
        units1.add(un1);
        units1.add(un2);
        units1.add(un3);
        units2.add(un4);
        units2.add(un5);
        units3.add(un6);
        units3.add(un7);
        pp1.setId(1);
        pp2.setId(2);
        pp3.setId(3);
        pp1.setName("moskow");
        pp2.setName("ivanovo");
        pp3.setName("vladimir");
        pp1.setUnits(units1);
        pp2.setUnits(units2);
        pp3.setUnits(units3);
        ppAll.add(pp1);
        ppAll.add(pp2);
        ppAll.add(pp3);
        System.out.println(ppAll.toString());
        System.out.println("-----------------------------------------------------------");
        Map<String, PPSupe> ppName = ppAll.stream().collect(Collectors.toMap(i -> i.getName(), Function.identity()));
        System.out.println(ppName.toString());
        System.out.println("-----------------------------------------------------------");
        Map<String, Map<String, DataMeneger>> objectMap = ppAll.stream()
                .collect(Collectors.toMap(i -> i.getName(), i -> i.getUnits().stream()
                        .collect(Collectors.toMap(item -> item.getName(), Function.identity()))));
        System.out.println("-----------------------------------------------------------");
        System.out.println(objectMap.toString());
    }

}
