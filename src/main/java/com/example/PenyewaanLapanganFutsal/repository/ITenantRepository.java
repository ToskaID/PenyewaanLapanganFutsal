package com.example.PenyewaanLapanganFutsal.repository;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Tenant;

import java.util.List;

public interface ITenantRepository {

    Tenant create(Tenant tenant) throws Exception;
    List<Tenant> findAll() throws Exception;
    List<Tenant> findById(String id) throws Exception;
    Tenant update(Tenant tenant, String id) throws Exception;
    void delete(String id) throws Exception;
}
