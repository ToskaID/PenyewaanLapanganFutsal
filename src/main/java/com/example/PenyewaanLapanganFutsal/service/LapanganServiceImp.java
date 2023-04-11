package com.example.PenyewaanLapanganFutsal.service;

import com.example.PenyewaanLapanganFutsal.exception.NotFoundException;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Lapangan;
import com.example.PenyewaanLapanganFutsal.model.entitiy.Tenant;
import com.example.PenyewaanLapanganFutsal.repository.ILapanganRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LapanganServiceImp implements ILapanganService{

    private ILapanganRepository lapanganRepository;

    public LapanganServiceImp(ILapanganRepository lapanganRepository) {
        this.lapanganRepository = lapanganRepository;
    }

    @Override
    public Lapangan create(Lapangan lapangan) {
        try{
            return lapanganRepository.create(lapangan);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Lapangan> findAll() throws Exception {
        try {
            List<Lapangan> lapangans = lapanganRepository.findAll();
            if (lapangans.isEmpty()){
                throw new NotFoundException("Tenant is empty");
            }
            return lapangans;
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public List<Lapangan> findById(String id) throws Exception {
        try{
            List<Lapangan> lapangans = lapanganRepository.findById(id);
            if (lapangans.isEmpty()){
                throw  new NotFoundException("Lapangan id not found");
            }
            return  lapangans;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Lapangan update(Lapangan lapangan, String id) throws Exception {
        try{
            findById(id);
            return lapanganRepository.update(lapangan,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            findById(id);
            lapanganRepository.delete(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
