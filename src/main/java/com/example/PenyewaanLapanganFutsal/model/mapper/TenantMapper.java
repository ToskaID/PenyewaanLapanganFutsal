package com.example.PenyewaanLapanganFutsal.model.mapper;


import com.example.PenyewaanLapanganFutsal.model.entitiy.Tenant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TenantMapper implements RowMapper<Tenant> {
    @Override
    public Tenant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tenant tenant = new Tenant();
        tenant.setId(rs.getString("id"));
        tenant.setNamaTenant(rs.getString("nama_tenant"));
        tenant.setNomerHp(rs.getString("no_hp"));
        return tenant;
    }
}
