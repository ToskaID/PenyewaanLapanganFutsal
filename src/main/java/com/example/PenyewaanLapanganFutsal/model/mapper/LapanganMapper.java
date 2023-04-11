package com.example.PenyewaanLapanganFutsal.model.mapper;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Lapangan;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LapanganMapper implements RowMapper<Lapangan> {
    @Override
    public Lapangan mapRow(ResultSet rs, int rowNum) throws SQLException {
        Lapangan l = new Lapangan();
        l.setId(rs.getString("id"));
        l.setNamaLapangan(rs.getString("nama_lapangan"));
        l.setJenisLapangan(rs.getString("jenis_lapangan"));
        l.setHarga(rs.getInt("harga"));

        return l;
    }
}
