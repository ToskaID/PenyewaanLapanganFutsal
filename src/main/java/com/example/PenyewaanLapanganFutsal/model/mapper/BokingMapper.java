package com.example.PenyewaanLapanganFutsal.model.mapper;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Boking;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Lapangan;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Tenant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BokingMapper implements RowMapper<Boking> {
    @Override
    public Boking mapRow(ResultSet rs, int rowNum) throws SQLException {
        Boking b = new Boking();
        b.setId(rs.getString("id"));
        b.setTanggalBoking(rs.getDate("tanggal_boking"));
        b.setTanggalMain(rs.getDate("tanggal_main"));
        b.setJamMain(rs.getTime("jam_main"));
        b.setJamSelesai(rs.getTime("jam_selesai"));
        b.setDurasi(rs.getInt("durasi"));
        b.setUangBoking(rs.getDouble("uang_boking"));

        Tenant tenant = new Tenant();
        tenant.setId(rs.getString("id"));

        Lapangan l = new Lapangan();
        l.setId(rs.getString("id"));

        b.setTenantId(tenant);
        b.setLapanganId(l);


        return b;
    }
}
