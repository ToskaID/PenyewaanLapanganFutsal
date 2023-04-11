package com.example.PenyewaanLapanganFutsal.controller;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Tenant;
import com.example.PenyewaanLapanganFutsal.model.request.TenantRequest;
import com.example.PenyewaanLapanganFutsal.model.response.SuccessResponse;
import com.example.PenyewaanLapanganFutsal.repository.ITenantRepository;
import com.example.PenyewaanLapanganFutsal.service.ITenantService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant")
public class TenantController {
    ITenantService tenantService;
    ModelMapper modelMapper;
    @Autowired
    public TenantController(ITenantService tenantService, ModelMapper modelMapper) {
        this.tenantService = tenantService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity createTenant(@Valid @RequestBody TenantRequest tenantRequest) throws Exception {
        Tenant newTenant = modelMapper.map(tenantRequest, Tenant.class);
        Tenant result = tenantService.create(newTenant);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<Tenant>("CREATE TENANT SUCCESS", result));
    }

    @GetMapping
    public ResponseEntity findAllTenant() throws Exception {
        List<Tenant> tenants = tenantService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<List<Tenant>>("SUCCESS", tenants));
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") String id) throws Exception {
        List<Tenant> tenants = tenantService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<List<Tenant>>("ID NOT FOUND", tenants));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody TenantRequest tenantRequest, @PathVariable String id) throws Exception {
        Tenant tenant = modelMapper.map(tenantRequest, Tenant.class);
        Tenant result = tenantService.update(tenant, id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Tenant>("UPDATE SUCCESS", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable String id) throws Exception {
        tenantService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("DELETE SUCCESS", "null"));
    }

}