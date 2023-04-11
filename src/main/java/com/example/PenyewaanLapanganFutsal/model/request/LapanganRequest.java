package com.example.PenyewaanLapanganFutsal.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LapanganRequest {

    @NotBlank
    private String namaLapangan;

    @NotBlank
    private String jenisLapangan;

    private Integer harga;
}
