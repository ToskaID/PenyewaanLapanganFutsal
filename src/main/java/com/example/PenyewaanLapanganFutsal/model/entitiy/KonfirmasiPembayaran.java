package com.example.PenyewaanLapanganFutsal.model.entitiy;

import lombok.Data;

@Data
public class KonfirmasiPembayaran {

    private String id;
    private Double total;
    private Boking boking;
}
