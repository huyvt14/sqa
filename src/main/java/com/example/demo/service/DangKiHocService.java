package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.DangKiHocRepository;

@Service
public class DangKiHocService {
	private DangKiHocRepository dangKiHocRepository;
	
	public DangKiHocService(DangKiHocRepository dangKiHocRepository) {
		this.dangKiHocRepository = dangKiHocRepository;
	}
}
