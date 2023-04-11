package com.example.PenyewaanLapanganFutsal.repository;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Boking;
import com.example.PenyewaanLapanganFutsal.model.mapper.BokingMapper;
import com.example.PenyewaanLapanganFutsal.model.mapper.LapanganMapper;
import com.example.PenyewaanLapanganFutsal.util.IRandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BokingRepositoryImp implements IBokingRepository{

    private IRandomStringGenerator randomStringGenerator;
    private JdbcTemplate jdbcTemplate;

    private final String SQL_CREATE = "insert into boking values (?,?,?,?,?,?,?,?,?)";
    private final String SQL_Find_All = "select * from boking";
    private final String SQL_Find_By_Id = "select * from boking where id = ?";
    private final String SQL_UPDATE = "update boking set tanggal_boking = ?,tanggal_main = ?,jam_main = ?, jam_selesai = ?,durasi = ?,uang_boking = ? ,tenant_id = ?, lapangan_id = ? where id = ?";
    private final String SQL_DELETE = "delete from boking where id = ?";

    @Autowired
    public BokingRepositoryImp(IRandomStringGenerator randomStringGenerator, JdbcTemplate jdbcTemplate) {
        this.randomStringGenerator = randomStringGenerator;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boking create(Boking boking) throws Exception {
        boking.setId(randomStringGenerator.random());
        jdbcTemplate.update(SQL_CREATE, boking.getId(), boking.getTanggalBoking(), boking.getTanggalMain(), boking.getJamMain(),
                boking.getJamSelesai(), boking.getDurasi(),boking.getUangBoking() ,boking.getTenantId().getId(), boking.getLapanganId().getId());
        return boking;
    }

    @Override
    public List<Boking> findAll() throws Exception {
        return jdbcTemplate.query(SQL_Find_All, new BokingMapper());
    }

    @Override
    public List<Boking> findById(String id) throws Exception {
        return jdbcTemplate.query(SQL_Find_By_Id, new BokingMapper(), id);
    }

    @Override
    public Boking update(Boking boking, String id) throws Exception {
        jdbcTemplate.update(SQL_UPDATE,  boking.getTanggalBoking(), boking.getTanggalMain(), boking.getJamMain(),
                boking.getJamSelesai(), boking.getDurasi(), boking.getTenantId(), boking.getLapanganId(), id);
        return boking;
    }

    @Override
    public void delete(String id) throws Exception {
        jdbcTemplate.update(SQL_DELETE,id);

    }
}
