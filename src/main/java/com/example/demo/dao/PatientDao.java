package com.example.demo.dao;

import com.example.demo.model.Patient;

import java.util.List;

public interface PatientDao {
    List<Patient> getAllPatients();
    Patient getPatientById(int id);
    void addPatient(Patient patient);
    void updatePatient(int id, Patient patient);
    void deletePatient(int id);

}
