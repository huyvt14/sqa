package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.SinhVien;
import com.example.demo.repository.SinhVienRepository;

@Service
public class SinhVienService {
	private SinhVienRepository sinhVienRepository;
	
	public SinhVienService(SinhVienRepository sinhVienRepository) {
		this.sinhVienRepository = sinhVienRepository;
	}
	public List<SinhVien> listAll() {
        return sinhVienRepository.findAll();
    }
	public void saveStudent(SinhVien sinhvien) {
        sinhVienRepository.save(sinhvien);
    }
	public SinhVien getStudentById(int id) {
	    Optional<SinhVien> sinhVienOptional = sinhVienRepository.findById(id);
	    if (sinhVienOptional.isPresent()) {
	        return sinhVienOptional.get();
	    } else {
	        return null; 
	    }
	}
	public void deleteStudent(int id) {
	        sinhVienRepository.deleteById(id);
	}
}
