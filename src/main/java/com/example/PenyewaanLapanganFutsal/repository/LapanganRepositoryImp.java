package com.example.PenyewaanLapanganFutsal.repository;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Lapangan;
import com.example.PenyewaanLapanganFutsal.model.mapper.LapanganMapper;
import com.example.PenyewaanLapanganFutsal.util.IRandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public class LapanganRepositoryImp implements ILapanganRepository{

    private IRandomStringGenerator randomStringGenerator;
    private JdbcTemplate jdbcTemplate;

    private final String SQL_CREATE = "insert into lapangan values (?,?,?,?)";
    private final String SQL_Find_All = "select * from lapangan";
    private final String SQL_Find_By_Id = "select * from lapangan where id = ?";
    private final String SQL_UPDATE = "update lapangan set nama_lapangan = ?,jenis_lapangan = ?,harga = ? where id = ?";
    private final String SQL_DELETE = "delete from lapangan where id = ?";

    @Autowired
    public LapanganRepositoryImp(IRandomStringGenerator randomStringGenerator, JdbcTemplate jdbcTemplate) {
        this.randomStringGenerator = randomStringGenerator;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Lapangan create(Lapangan lapangan) throws Exception {
        lapangan.setId(randomStringGenerator.random());
        jdbcTemplate.update(SQL_CREATE, lapangan.getId(), lapangan.getNamaLapangan(), lapangan.getJenisLapangan(), lapangan.getHarga());
        return lapangan;
    }

    @Override
    public List<Lapangan> findAll() throws Exception {
        return jdbcTemplate.query(SQL_Find_All, new LapanganMapper());
    }

    @Override
    public List<Lapangan> findById(String id) throws Exception {
        return jdbcTemplate.query(SQL_Find_By_Id, new LapanganMapper(), id);
    }

    @Override
    public Lapangan update(Lapangan lapangan, String id) throws Exception {
        jdbcTemplate.update(SQL_UPDATE,  lapangan.getNamaLapangan(), lapangan.getJenisLapangan(), lapangan.getHarga(),id);
        return lapangan;
    }

    @Override
    public void delete(String id) throws Exception {
        jdbcTemplate.update(SQL_DELETE,id);
    }
}
