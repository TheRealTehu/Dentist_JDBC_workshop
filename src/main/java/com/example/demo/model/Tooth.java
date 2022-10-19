package com.example.demo.model;

import com.example.demo.model.enums.ToothType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tooth {
    private int id;
    private int patientId;
    private ToothType type;
    private boolean isFilled;
}