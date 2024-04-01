package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.SVKhoa;
import com.example.demo.repository.SVKhoaRepository;

@Service
public class SVKhoaService {
	private SVKhoaRepository svKhoaRepository;
	
	public SVKhoaService(SVKhoaRepository svKhoaRepository) {
		this.svKhoaRepository= svKhoaRepository;
	}
	
	public void saveStudent(SVKhoa sinhvienkhoa) {
		svKhoaRepository.save(sinhvienkhoa);
    }
	public SVKhoa getStudentById(int id) {
		return svKhoaRepository.findBySinhVienId(id);
	}
	public void deleteBySinhVienId(int id) {
		svKhoaRepository.deleteBySinhVienId(id);
	}
}
