package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.QuanTriVienRepository;

@Service
public class QuanTriVienService {
	private QuanTriVienRepository quanTriVienRepository;
	
	public QuanTriVienService(QuanTriVienRepository quanTriVienRepository) {
		this.quanTriVienRepository = quanTriVienRepository;
	}
}
