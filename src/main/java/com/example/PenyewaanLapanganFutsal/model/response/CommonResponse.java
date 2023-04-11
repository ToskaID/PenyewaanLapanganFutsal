package com.example.PenyewaanLapanganFutsal.model.response;

import lombok.Data;

@Data
public abstract class CommonResponse {

    private String status;
    private String message;
    private String code;
}
