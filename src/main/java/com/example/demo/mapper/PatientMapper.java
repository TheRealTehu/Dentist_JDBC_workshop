package com.example.demo.mapper;

import com.example.demo.model.Patient;
import com.example.demo.model.enums.Gender;
import com.example.demo.service.ToothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PatientMapper implements RowMapper<Patient> {
    private ToothService service; //NE CSINÁLD SOHA SEMMIKOR

    @Autowired
    public PatientMapper(ToothService service) {
        this.service = service;
    }

    @Override
    public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Patient patient = new Patient();
        patient.setId(rs.getInt("id"));
        patient.setName(rs.getString("name"));
        patient.setAge(rs.getInt("age"));
        patient.setGender(Gender.valueOf(rs.getString("gender")));

        patient.setTeeth(service.getAllTeethForPatientById(rs.getInt("id")));

        return patient;
    }
}
