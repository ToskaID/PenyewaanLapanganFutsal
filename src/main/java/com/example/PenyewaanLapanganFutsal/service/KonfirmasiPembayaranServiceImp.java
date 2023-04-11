package com.example.PenyewaanLapanganFutsal.service;

import com.example.PenyewaanLapanganFutsal.exception.NotFoundException;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Boking;
import com.example.PenyewaanLapanganFutsal.model.entitiy.KonfirmasiPembayaran;
import com.example.PenyewaanLapanganFutsal.repository.IKonfirmasiPembayaranRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KonfirmasiPembayaranServiceImp implements  IKonfirmasiPembayaranService{

    private IKonfirmasiPembayaranRepo konfirmasiPembayaranRepo;

    @Autowired
    public KonfirmasiPembayaranServiceImp(IKonfirmasiPembayaranRepo konfirmasiPembayaranRepo) {
        this.konfirmasiPembayaranRepo = konfirmasiPembayaranRepo;
    }

    @Override
    public KonfirmasiPembayaran create(KonfirmasiPembayaran konfirmasiPembayaran) throws Exception {
        try{
            return konfirmasiPembayaranRepo.create(konfirmasiPembayaran);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<KonfirmasiPembayaran> findAll() throws Exception {
        try {
            List<KonfirmasiPembayaran> konfirmasiPembayarans = konfirmasiPembayaranRepo.findAll();
            if (konfirmasiPembayarans.isEmpty()){
                throw new NotFoundException("Konfirmasi pembayaran is empty");
            }
            return konfirmasiPembayarans;
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public List<KonfirmasiPembayaran> findById(String id) throws Exception {

        try{
            List<KonfirmasiPembayaran> konfirmasiPembayarans = konfirmasiPembayaranRepo.findById(id);
            if (konfirmasiPembayarans.isEmpty()){
                throw  new NotFoundException("Lapangan id not found");
            }
            return konfirmasiPembayarans;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
