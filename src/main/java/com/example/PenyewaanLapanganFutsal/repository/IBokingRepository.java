package com.example.PenyewaanLapanganFutsal.repository;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Boking;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Lapangan;

import java.util.List;

public interface IBokingRepository {

    Boking create(Boking boking) throws Exception;
    List<Boking> findAll() throws Exception;
    List<Boking> findById(String id) throws Exception;
    Boking update(Boking boking, String id) throws Exception;
    void delete(String id) throws Exception;
}
