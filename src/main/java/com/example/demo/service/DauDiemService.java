package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.DauDiem;
import com.example.demo.repository.DauDiemRepository;

@Service
public class DauDiemService {
    private DauDiemRepository dauDiemRepository;
    
    public DauDiemService(DauDiemRepository dauDiemRepository) {
        this.dauDiemRepository = dauDiemRepository;
    }
    
    public DauDiem layDauDiem(String ten) {
        return dauDiemRepository.findByTen(ten);
    }
    
    public DauDiem luuVaLayRa(DauDiem dd) {
        return dauDiemRepository.save(dd);
    }
}
