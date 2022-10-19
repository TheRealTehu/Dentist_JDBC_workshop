package com.example.demo.dao;

import com.example.demo.mapper.PatientMapper;
import com.example.demo.model.Patient;
import com.example.demo.model.Tooth;
import com.example.demo.model.enums.Gender;
import com.example.demo.model.enums.ToothType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientDaoJdbcImpl implements PatientDao{
    private JdbcTemplate template;
    private PatientMapper mapper;

    @Autowired
    public PatientDaoJdbcImpl(JdbcTemplate template, PatientMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    @Override
    public List<Patient> getAllPatients() {
        final String SQL = "SELECT patients.id, patients.name, patients.age, patients.gender," +
                "teeth.id, teeth.patient_id, teeth.tooth_type, teeth.is_filled " +
                "FROM patients LEFT JOIN teeth ON patients.id = teeth.patient_id;";

        List<Patient> patients = template.query(SQL, new ResultSetExtractor<List<Patient>>() {
            @Override
            public List<Patient> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Patient> patientList = new ArrayList<>();
                Patient actualPatient = new Patient();

                while (rs.next()){
                    if(actualPatient.getId() != null && rs.getLong("patients.id") == actualPatient.getId()){
                        Tooth tooth = getToothFromResultSet(rs);

                        actualPatient.addTooth(tooth);
                    } else {
                        if(actualPatient.getId() != null){
                            patientList.add(actualPatient);
                        }

                        actualPatient = getPatientFromResultSet(rs);

                        if(rs.getString("teeth.tooth_type") != null){
                            Tooth tooth = getToothFromResultSet(rs);

                            actualPatient.addTooth(tooth);
                        }
                    }
                }
                patientList.add(actualPatient);
                return patientList;
            }
        });

        return patients;
    }

    private Patient getPatientFromResultSet(ResultSet rs) throws SQLException {
        Patient actualPatient;
        Patient patient = new Patient();
        patient.setId(rs.getInt("patients.id"));
        patient.setName(rs.getString("patients.name"));
        patient.setAge(rs.getInt("patients.age"));
        patient.setGender(Gender.valueOf(rs.getString("patients.gender")));

        actualPatient = patient;
        return actualPatient;
    }

    private Tooth getToothFromResultSet(ResultSet rs) throws SQLException {
        Tooth tooth = new Tooth();
        tooth.setId(rs.getInt("teeth.id"));
        tooth.setPatientId(rs.getInt("teeth.patient_id"));
        tooth.setType(ToothType.valueOf(rs.getString("teeth.tooth_type")));
        tooth.setFilled(rs.getBoolean("teeth.is_filled"));
        return tooth;
    }

    @Override
    public Patient getPatientById(int id) {
        return null;
    }

    @Override
    public void addPatient(Patient patient) {

    }

    @Override
    public void updatePatient(int id, Patient patient) {

    }

    @Override
    public void deletePatient(int id) {

    }
}