package com.example.PenyewaanLapanganFutsal.controller;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Boking;
import com.example.PenyewaanLapanganFutsal.model.entitiy.KonfirmasiPembayaran;
import com.example.PenyewaanLapanganFutsal.model.request.KonfirmasiPembayaranRequest;
import com.example.PenyewaanLapanganFutsal.model.response.SuccessResponse;
import com.example.PenyewaanLapanganFutsal.service.IKonfirmasiPembayaranService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/konfirmasi")
public class KonfirmasiPembayaranController {

    private IKonfirmasiPembayaranService konfirmasiPembayaranService;
    private ModelMapper modelMapper;

    @Autowired
    public KonfirmasiPembayaranController(IKonfirmasiPembayaranService konfirmasiPembayaranService, ModelMapper modelMapper) {
        this.konfirmasiPembayaranService = konfirmasiPembayaranService;
        this.modelMapper = modelMapper;
    }

        @PostMapping
        public ResponseEntity createLapangan(@Valid @RequestBody KonfirmasiPembayaranRequest konfirmasiPembayaranRequest) throws Exception {
            KonfirmasiPembayaran konfirmasiPembayaran = modelMapper.map(konfirmasiPembayaranRequest,  KonfirmasiPembayaran.class);
            KonfirmasiPembayaran result = konfirmasiPembayaranService.create(konfirmasiPembayaran);
            return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<KonfirmasiPembayaran>("CREATE BOOKING SUCCESS", result));
        }

    @GetMapping
    public ResponseEntity findAllTenant() throws Exception {
        List<KonfirmasiPembayaran> konfirmasiPembayarans = konfirmasiPembayaranService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<List<KonfirmasiPembayaran>>("SUCCESS", konfirmasiPembayarans));
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") String id) throws Exception {
        List<KonfirmasiPembayaran> konfirmasiPembayarans = konfirmasiPembayaranService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<List<KonfirmasiPembayaran>>("ID NOT FOUND", konfirmasiPembayarans));
    }





}
