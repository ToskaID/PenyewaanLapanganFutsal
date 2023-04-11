package com.example.PenyewaanLapanganFutsal.repository;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Lapangan;


import java.util.List;

public interface ILapanganRepository {

    Lapangan create(Lapangan lapangan) throws Exception;
    List<Lapangan> findAll() throws Exception;
    List<Lapangan> findById(String id) throws Exception;
    Lapangan update(Lapangan lapangan, String id) throws Exception;
    void delete(String id) throws Exception;
}
