package com.example.PenyewaanLapanganFutsal.model.request;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Boking;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Lapangan;
import lombok.Data;

@Data
public class TotalRequest {

    private Lapangan lapangan;
    private Boking boking;
}
