package com.example.PenyewaanLapanganFutsal.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TenantRequest {

    @NotBlank
    private String namaTenant;

    @NotBlank
    private String nomerHp;
}
