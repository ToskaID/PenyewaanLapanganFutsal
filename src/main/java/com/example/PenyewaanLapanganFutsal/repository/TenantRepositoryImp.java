package com.example.PenyewaanLapanganFutsal.repository;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Tenant;
import com.example.PenyewaanLapanganFutsal.model.mapper.TenantMapper;
import com.example.PenyewaanLapanganFutsal.util.IRandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TenantRepositoryImp implements ITenantRepository{
    private IRandomStringGenerator randomStringGenerator;
    private JdbcTemplate jdbcTemplate;

    private final String SQL_CREATE = "insert into tenant values(?,?,?)";
    private final String SQL_Find_All = "select * from tenant";
    private final String SQL_Find_By_Id = "select * from tenant where id = ?";
    private final String SQL_UPDATE = "update tenant set nama_tenant = ?,no_hp = ? where id = ?";
    private final String SQL_DELETE = "delete from tenant where id = ?";

    @Autowired
    public TenantRepositoryImp(IRandomStringGenerator randomStringGenerator, JdbcTemplate jdbcTemplate) {
        this.randomStringGenerator = randomStringGenerator;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Tenant create(Tenant tenant) throws Exception {
        tenant.setId(randomStringGenerator.random());
        jdbcTemplate.update(SQL_CREATE, tenant.getId(), tenant.getNamaTenant(), tenant.getNomerHp());
        return tenant;
    }

    @Override
    public List<Tenant> findAll() throws Exception {
        return jdbcTemplate.query(SQL_Find_All, new TenantMapper());
    }

    @Override
    public List<Tenant> findById(String id) throws Exception {
        return jdbcTemplate.query(SQL_Find_By_Id, new TenantMapper(), id);
    }

    @Override
    public Tenant update(Tenant tenant, String id) throws Exception {
        jdbcTemplate.update(SQL_UPDATE,  tenant.getNamaTenant(), tenant.getNomerHp(),id);
        return tenant;
    }

    @Override
    public void delete(String id) throws Exception {
        jdbcTemplate.update(SQL_DELETE,id);
    }
}
