package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Khoa;
import com.example.demo.repository.KhoaRepository;

@Service
public class KhoaService {
	private KhoaRepository khoaRepository;
	
	public KhoaService(KhoaRepository khoaRepository) {
		this.khoaRepository = khoaRepository;
	}
	public List<Khoa> listAllKhoa() {
        return khoaRepository.findAll();
    }
	public void saveKhoa(Khoa khoa) {
        khoaRepository.save(khoa);
    }
	public Optional<Khoa> getKhoaById(int id) {
        return khoaRepository.findById(id);
    }
	public void deleteKhoa(int id) {
	        khoaRepository.deleteById(id);
	}
}
