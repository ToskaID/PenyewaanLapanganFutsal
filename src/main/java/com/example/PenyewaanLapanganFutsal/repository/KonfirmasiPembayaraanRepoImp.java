package com.example.PenyewaanLapanganFutsal.repository;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Boking;
import com.example.PenyewaanLapanganFutsal.model.entitiy.KonfirmasiPembayaran;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Lapangan;
import com.example.PenyewaanLapanganFutsal.model.mapper.KonfirmasiPembayaraanMapper;
import com.example.PenyewaanLapanganFutsal.util.IRandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KonfirmasiPembayaraanRepoImp implements IKonfirmasiPembayaranRepo {
    @Autowired
    private LapanganRepositoryImp lapanganRepositoryImp;

    private IRandomStringGenerator randomStringGenerator;
    private JdbcTemplate jdbcTemplate;

    private final String SQL_CREATE = "insert into konfirmasi_pembayaran  values (?,?,?)";
    private final String SQL_Find_All = "select * from konfirmasi_pembayaran";
    private final String SQL_Find_By_Id = "select * from konfirmasi_pembayaran where id = ?";

    @Autowired
    public KonfirmasiPembayaraanRepoImp(IRandomStringGenerator randomStringGenerator, JdbcTemplate jdbcTemplate) {
        this.randomStringGenerator = randomStringGenerator;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public KonfirmasiPembayaran create(KonfirmasiPembayaran konfirmasiPembayaran) throws Exception {
        konfirmasiPembayaran.setId(randomStringGenerator.random());

        konfirmasiPembayaran.setTotal(0.0);

        jdbcTemplate.update(SQL_CREATE, konfirmasiPembayaran.getId(), konfirmasiPembayaran.getTotal(),konfirmasiPembayaran.getBoking().getId());
//        Boking boking = jdbcTemplate.queryForObject(SQL_CREATE, Boking.class, konfirmasiPembayaran.getId(), konfirmasiPembayaran.getTotal(),konfirmasiPembayaran.getBoking().getId());

//        Lapangan lapangan = boking.getLapanganId();
//
//        double total = boking.getDurasi() * lapangan.getHarga() - boking.getUangBoking();

      //  konfirmasiPembayaran.setTotal(total);

        String SQL_KONFIRMASI_PEMBAYARAN = "select id."
                                                                + "from"
                                                                + "konfirmasi_pembayaraan kp"
                                                                + "join boking b on (kp.boking_id = b.id)"
                                                                + "join lapangan l on (b.lapangan_id = l.id)";




        return konfirmasiPembayaran;

    }

    @Override
    public List<KonfirmasiPembayaran> findAll() throws Exception {
        return jdbcTemplate.query(SQL_Find_All, new KonfirmasiPembayaraanMapper());
    }

    @Override
    public List<KonfirmasiPembayaran> findById(String id) throws Exception {
        return jdbcTemplate.query(SQL_Find_By_Id, new KonfirmasiPembayaraanMapper(), id);
    }
}
