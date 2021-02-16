package com.example.demo.inicialisation;

import lombok.Data;

@Data
public class Zoo {
    private int age;
    private String name;

    public Zoo(){
        System.out.println("Конструктор Zoo");
    }

    {
        System.out.println("Zoo not static block");
    }

    static
    {
        System.out.println("Zoo static block");
    }

    public void foo(){
        System.out.println("Hello!");
    }
}
