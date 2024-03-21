package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.KhoaRepository;

@Service
public class KhoaService {
	private KhoaRepository khoaRepository;
	
	public KhoaService(KhoaRepository khoaRepository) {
		this.khoaRepository = khoaRepository;
	}
}
