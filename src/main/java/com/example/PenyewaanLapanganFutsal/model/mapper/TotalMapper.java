package com.example.PenyewaanLapanganFutsal.model.mapper;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Boking;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Lapangan;
import com.example.PenyewaanLapanganFutsal.model.request.TotalRequest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TotalMapper implements RowMapper<TotalRequest> {
    @Override
    public TotalRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
        TotalRequest tMapper  =new TotalRequest();

        Lapangan lapangan = new Lapangan();
        lapangan.setId(rs.getString("id"));
        Boking boking = new Boking();
        boking.setId(rs.getString("id"));

        tMapper.setBoking(boking);
        tMapper.setLapangan(lapangan);

        return tMapper;
    }
}
