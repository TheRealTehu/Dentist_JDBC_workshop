package com.example.demo.controller;

import com.example.demo.model.Tooth;
import com.example.demo.model.dto.ToothDto;
import com.example.demo.service.ToothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tooth")
public class ToothController {
    private ToothService service;

    @Autowired
    public ToothController(ToothService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tooth> getAllTeeth() {
        return service.getAllTeeth();
    }

    @GetMapping("/{id}")
    public Tooth getToothById(@PathVariable("id") int id) {
        return service.getToothById(id);
    }

    @GetMapping("/patient/{patient_id}")
    public List<Tooth> getAllTeethForPatientById(@PathVariable("patient_id") int patientId) {
        return service.getAllTeethForPatientById(patientId);
    }

    @PostMapping
    public void addTooth(@RequestBody ToothDto tooth) {
        service.addTooth(tooth);
    }

    @PutMapping("/{id}")
    public void updateTooth(@RequestBody ToothDto tooth, @PathVariable("id") int id) {
        service.updateTooth(tooth, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTooth(@PathVariable("id") int id) {
        service.deleteTooth(id);
    }
}
