package com.example.demo.model;

import com.example.demo.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Patient {
    private Integer id;
    private String name;
    private Gender gender;
    private int age;
    private List<Tooth> teeth;

    public Patient() {
        teeth = new ArrayList<>();
    }

    public void addTooth(Tooth tooth) {
        teeth.add(tooth);
    }
}
