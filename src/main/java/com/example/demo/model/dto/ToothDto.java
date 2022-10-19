package com.example.demo.model.dto;


import com.example.demo.model.enums.ToothType;
import lombok.Data;

@Data
public class ToothDto {
    private int patientId;
    private ToothType type;
    private boolean isFilled;
}