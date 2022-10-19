package com.example.demo.dao;

import com.example.demo.mapper.ToothMapper;
import com.example.demo.model.Tooth;
import com.example.demo.model.dto.ToothDto;
import com.example.demo.model.enums.ToothType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ToothDaoJdbcImpl implements ToothDao {
    private JdbcTemplate template;
    private ToothMapper mapper;

    @Autowired
    public ToothDaoJdbcImpl(JdbcTemplate template, ToothMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    public Connection getConnection() {
        Connection connection = null;
        String userName = "name";
        String password = "pass";
        String host = "localhost";
        String port = "5432";
        String databaseName = "dentist_db";

        try {
            connection = DriverManager.getConnection(
                    "jdbc:h2://" + host + ":" + port + "/" + databaseName, userName, password
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Tooth> getAllTeethOldVersion() {
        try (Connection connection = getConnection()) {
            final String SQL = "SELECT id, patient_id, tooth_type, is_filled FROM teeth;";
            PreparedStatement st = connection.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();
            List<Tooth> teeth = new ArrayList<>();
            while (rs.next()) {
                Tooth tooth = new Tooth(rs.getInt(1), rs.getInt(2),
                        ToothType.valueOf(rs.getString(3)), rs.getBoolean(4));
                teeth.add(tooth);
            }

            return teeth;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Tooth> getAllTeeth() {
        final String SQL = "SELECT id, patient_id, tooth_type, is_filled FROM teeth;";

        return template.query(SQL, mapper);
    }


    @Override
    public Tooth getToothById(int id) {
        final String SQL = "SELECT id, patient_id, tooth_type, is_filled FROM teeth WHERE id = ?;";

        return template.queryForObject(SQL, mapper, id);
    }

    @Override
    public List<Tooth> getAllTeethForPatientById(int patientId) {
        final String SQL = "SELECT id, patient_id, tooth_type, is_filled FROM teeth WHERE patient_id = ?;";

        return template.query(SQL, mapper, patientId);
    }

    @Override
    public void addTooth(ToothDto toothDto) {
        final String SQL = "INSERT INTO teeth(patient_id, tooth_type, is_filled) VALUES (?,?,?);";

        Object[] args = new Object[]{
                toothDto.getPatientId(),
                toothDto.getType().toString(),
                toothDto.isFilled()
        };

        template.update(SQL, args);
    }

    public Tooth addToothAndReturnNewTooth(ToothDto toothDto){
        final String SQL = "INSERT INTO teeth(patient_id, tooth_type, is_filled) VALUES (?,?,?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        template.update(con -> {
            PreparedStatement st = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, toothDto.getPatientId());
            st.setString(2, toothDto.getType().toString());
            st.setBoolean(3, toothDto.isFilled());
            return st;}, keyHolder);

        return getToothById(keyHolder.getKey().intValue());
    }

    @Override
    public void updateTooth(ToothDto tooth, int id) {
        final String SQL = "UPDATE teeth SET patient_id = ?, tooth_type = ?, is_filled = ? WHERE id = ?;";

        Object[] args = new Object[]{
                tooth.getPatientId(),
                tooth.getType().toString(),
                tooth.isFilled(),
                id
        };

        template.update(SQL, args);
    }

    @Override
    public void deleteTooth(int id) {
        final String SQL = "DELETE FROM teeth WHERE id = ?";

        template.update(SQL, id);
    }
}
