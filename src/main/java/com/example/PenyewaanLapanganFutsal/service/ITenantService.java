package com.example.PenyewaanLapanganFutsal.service;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Tenant;

import java.util.List;

public interface ITenantService {

    Tenant create(Tenant tenant) ;
    List<Tenant> findAll() throws Exception;
    List<Tenant> findById(String id) throws Exception;
    Tenant update(Tenant tenant, String id) throws Exception;
    void delete(String id) throws Exception;

}
