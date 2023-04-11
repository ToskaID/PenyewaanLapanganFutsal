package com.example.PenyewaanLapanganFutsal.repository;

import com.example.PenyewaanLapanganFutsal.model.entitiy.KonfirmasiPembayaran;

import java.util.List;

public interface IKonfirmasiPembayaranRepo {

    KonfirmasiPembayaran create(KonfirmasiPembayaran konfirmasiPembayaran) throws Exception;
    List<KonfirmasiPembayaran> findAll() throws Exception;
    List<KonfirmasiPembayaran> findById(String id) throws Exception;
}
