package com.example.demo.service;

import com.example.demo.dao.ToothDao;
import com.example.demo.model.Tooth;
import com.example.demo.model.dto.ToothDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToothService {
    private ToothDao repository;

    @Autowired
    public ToothService(ToothDao repository) {
        this.repository = repository;
    }

    public List<Tooth> getAllTeeth() {
        return repository.getAllTeeth();
    }

    public Tooth getToothById(int id) {
        return repository.getToothById(id);
    }

    public List<Tooth> getAllTeethForPatientById(int patientId) {
        return repository.getAllTeethForPatientById(patientId);
    }

    public void addTooth(ToothDto tooth) {
        repository.addTooth(tooth);
    }

    public void updateTooth(ToothDto tooth, int id) {
        repository.updateTooth(tooth, id);
    }

    public void deleteTooth(int id) {
        repository.deleteTooth(id);
    }
}
