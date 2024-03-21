package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.ThanhVienRepository;

@Service
public class ThanhVienService {
	private ThanhVienRepository thanhVienRepository;
	
	public ThanhVienService(ThanhVienRepository thanhVienRepository) {
		this.thanhVienRepository = thanhVienRepository;
	}
}
