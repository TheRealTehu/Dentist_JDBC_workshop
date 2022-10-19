package com.example.demo.dao;

import com.example.demo.model.Tooth;
import com.example.demo.model.dto.ToothDto;

import java.util.List;

public interface ToothDao {
    List<Tooth> getAllTeeth();
    Tooth getToothById(int id);
    List<Tooth> getAllTeethForPatientById(int patientId);
    void addTooth(ToothDto tooth);
    void updateTooth(ToothDto tooth, int id);
    void deleteTooth(int id);
}
