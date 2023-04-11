package com.example.PenyewaanLapanganFutsal.controller;


import com.example.PenyewaanLapanganFutsal.model.entitiy.Boking;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Lapangan;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Tenant;
import com.example.PenyewaanLapanganFutsal.model.request.BokingRequest;
import com.example.PenyewaanLapanganFutsal.model.request.LapanganRequest;
import com.example.PenyewaanLapanganFutsal.model.response.SuccessResponse;
import com.example.PenyewaanLapanganFutsal.service.IBokingService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boking")
public class BokingController {

    private IBokingService bokingService;
    private ModelMapper modelMapper;

    @Autowired
    public BokingController(IBokingService bokingService, ModelMapper modelMapper) {
        this.bokingService = bokingService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity createLapangan(@Valid @RequestBody BokingRequest bokingRequest) throws Exception {
//        Lapangan lapangan = modelMapper.map(bokingRequest, Lapangan.class);
//        lapangan.setId(bokingRequest.getLapanganId());
//        Tenant tenant = modelMapper.map(bokingRequest, Tenant.class);
//        tenant.setId(bokingRequest.getTenantId());
        Boking boking = modelMapper.map(bokingRequest,  Boking.class);
//        boking.setTenantId(tenant);
//        boking.setLapanganId(lapangan);
        Boking result = bokingService.create(boking);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<Boking>("CREATE BOOKING SUCCESS", result));
    }

    @GetMapping
    public ResponseEntity findAllTenant() throws Exception {
        List<Boking> bokings = bokingService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<List<Boking>>("SUCCESS", bokings));
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") String id) throws Exception {
        List<Boking> bokings = bokingService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<List<Boking>>("ID NOT FOUND", bokings));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody BokingRequest bokingRequest, @PathVariable String id) throws Exception {
        Boking boking = modelMapper.map(bokingRequest, Boking.class);
        Boking result = bokingService.update(boking, id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Boking>("UPDATE SUCCESS", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable String id) throws Exception {
        bokingService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("DELETE SUCCESS", "null"));
    }
}
