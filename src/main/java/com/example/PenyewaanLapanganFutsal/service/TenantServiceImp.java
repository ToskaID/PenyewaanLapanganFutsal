package com.example.PenyewaanLapanganFutsal.service;

import com.example.PenyewaanLapanganFutsal.exception.NotFoundException;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Tenant;
import com.example.PenyewaanLapanganFutsal.repository.ITenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TenantServiceImp implements ITenantService{

    private ITenantRepository tenantRepository;
    @Autowired
    public TenantServiceImp(ITenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public Tenant create(Tenant tenant)  {
        try{
            return tenantRepository.create(tenant);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Tenant> findAll() throws Exception {
        try {
            List<Tenant> tenants = tenantRepository.findAll();
            if (tenants.isEmpty()){
                throw new NotFoundException("Tenant is empty");
            }
            return tenants;
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public List<Tenant> findById(String id) throws Exception {
        try{
            List<Tenant> tenants = tenantRepository.findById(id);
            if (tenants.isEmpty()){
                throw  new NotFoundException("Tenant id not found");
            }
            return  tenants;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Tenant update(Tenant tenant, String id) throws Exception {
        try{
            findById(id);
            return tenantRepository.update(tenant,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            findById(id);
            tenantRepository.delete(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
