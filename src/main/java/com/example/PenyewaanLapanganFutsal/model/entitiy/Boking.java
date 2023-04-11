package com.example.PenyewaanLapanganFutsal.model.entitiy;

;

import lombok.Data;


import java.sql.Time;
import java.util.Date;
;

@Data

public class Boking {

    private String id;
    private Date tanggalBoking;
    private Date tanggalMain;
    private Time jamMain;
    private Time jamSelesai;
    private Integer durasi;
    private Double uangBoking;
    private Tenant tenantId;
    private Lapangan lapanganId;

}
