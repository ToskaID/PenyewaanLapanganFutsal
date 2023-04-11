package com.example.PenyewaanLapanganFutsal.controller;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Lapangan;
import com.example.PenyewaanLapanganFutsal.model.request.LapanganRequest;
import com.example.PenyewaanLapanganFutsal.model.response.SuccessResponse;
import com.example.PenyewaanLapanganFutsal.service.ILapanganService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lapangan")
public class LapanganController {

    private ILapanganService lapanganService;
    private ModelMapper modelMapper;

    @Autowired
    public LapanganController(ILapanganService lapanganService, ModelMapper modelMapper) {
        this.lapanganService = lapanganService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity createLapangan(@Valid @RequestBody LapanganRequest lapanganRequest) throws Exception {
        Lapangan lapangan = modelMapper.map(lapanganRequest, Lapangan.class);
        Lapangan result = lapanganService.create(lapangan);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<Lapangan>("CREATE TENANT SUCCESS", result));
    }

    @GetMapping
    public ResponseEntity findAllTenant() throws Exception {
        List<Lapangan> lapangans = lapanganService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<List<Lapangan>>("SUCCESS", lapangans));
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") String id) throws Exception {
        List<Lapangan> lapangans = lapanganService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<List<Lapangan>>("ID NOT FOUND", lapangans));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody LapanganRequest lapanganRequest, @PathVariable String id) throws Exception {
        Lapangan lapangan = modelMapper.map(lapanganRequest, Lapangan.class);
        Lapangan result = lapanganService.update(lapangan, id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Lapangan>("UPDATE SUCCESS", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable String id) throws Exception {
        lapanganService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("DELETE SUCCESS", "null"));
    }
}
