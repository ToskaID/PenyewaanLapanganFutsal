package com.example.PenyewaanLapanganFutsal.service;

import com.example.PenyewaanLapanganFutsal.exception.NotFoundException;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Boking;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Lapangan;
import com.example.PenyewaanLapanganFutsal.repository.IBokingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BokingServiceImp implements IBokingService{

    private IBokingRepository bokingRepository;

    @Autowired
    public BokingServiceImp(IBokingRepository bokingRepository) {
        this.bokingRepository = bokingRepository;
    }

    @Override
    public Boking create(Boking boking) {
        try{
            return bokingRepository.create(boking);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Boking> findAll() throws Exception {
        try {
            List<Boking> bokings = bokingRepository.findAll();
            if (bokings.isEmpty()){
                throw new NotFoundException("Boking is empty");
            }
            return bokings;
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public List<Boking> findById(String id) throws Exception {
        try{
            List<Boking> bokings = bokingRepository.findById(id);
            if (bokings.isEmpty()){
                throw  new NotFoundException("Lapangan id not found");
            }
            return bokings;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boking update(Boking boking, String id) throws Exception {
        try{
            findById(id);
            return bokingRepository.update(boking,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            findById(id);
            bokingRepository.delete(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
