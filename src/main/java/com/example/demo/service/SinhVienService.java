package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.SinhVienRepository;

@Service
public class SinhVienService {
	private SinhVienRepository sinhVienRepository;
	
	public SinhVienService(SinhVienRepository sinhVienRepository) {
		this.sinhVienRepository = sinhVienRepository;
	}
}
