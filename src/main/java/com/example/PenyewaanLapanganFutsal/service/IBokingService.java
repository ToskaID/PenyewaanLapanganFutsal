package com.example.PenyewaanLapanganFutsal.service;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Boking;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Tenant;

import java.util.List;

public interface IBokingService {

    Boking create(Boking boking) ;
    List<Boking> findAll() throws Exception;
    List<Boking> findById(String id) throws Exception;
    Boking update(Boking boking, String id) throws Exception;
    void delete(String id) throws Exception;
}
