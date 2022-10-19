package com.example.demo.mapper;

import com.example.demo.model.Tooth;
import com.example.demo.model.enums.ToothType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class ToothMapper implements RowMapper<Tooth> {
    @Override
    public Tooth mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tooth tooth = new Tooth();
        tooth.setId(rs.getInt("id"));
        tooth.setPatientId(rs.getInt("patient_id"));
        tooth.setType(ToothType.valueOf(rs.getString("tooth_type")));
        tooth.setFilled(rs.getBoolean("is_filled"));

        return tooth;
    }
}
