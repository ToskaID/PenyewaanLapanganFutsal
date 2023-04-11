package com.example.PenyewaanLapanganFutsal.model.request;

import com.example.PenyewaanLapanganFutsal.model.entitiy.Lapangan;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Tenant;
import lombok.Data;


import java.sql.Time;
import java.util.Date;


@Data
public class BokingRequest {

    private Date tanggalBoking;
    private Date tanggalMain;
    private Time jamMain;
    private Time jamSelesai;
    private Integer durasi;
    private Double uangBoking;
    private Tenant tenantId;
    private Lapangan lapanganId;
}
