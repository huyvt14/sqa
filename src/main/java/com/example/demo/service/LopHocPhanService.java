package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.LopHocPhanRepository;

@Service
public class LopHocPhanService {
	private LopHocPhanRepository lopHocPhanRepository;
	
	public LopHocPhanService() {
		this.lopHocPhanRepository = lopHocPhanRepository;
	}
}
