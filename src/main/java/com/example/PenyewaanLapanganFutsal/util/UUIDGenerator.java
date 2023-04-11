package com.example.PenyewaanLapanganFutsal.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDGenerator implements IRandomStringGenerator{
    @Override
    public String random() {
        return UUID.randomUUID().toString();
    }
}
