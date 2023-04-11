package com.example.PenyewaanLapanganFutsal.model.mapper;


import com.example.PenyewaanLapanganFutsal.model.entitiy.Boking;
import com.example.PenyewaanLapanganFutsal.model.entitiy.KonfirmasiPembayaran;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KonfirmasiPembayaraanMapper implements RowMapper<KonfirmasiPembayaran> {
    @Override
    public KonfirmasiPembayaran mapRow(ResultSet rs, int rowNum) throws SQLException {
        KonfirmasiPembayaran kp = new KonfirmasiPembayaran();
        kp.setId(rs.getString("id"));
        kp.setTotal(rs.getDouble("total"));

        Boking bk = new Boking();
        bk.setId(rs.getString("id"));

        kp.setBoking(bk);

        return kp;
    }
}
