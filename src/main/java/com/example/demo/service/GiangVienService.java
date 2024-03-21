package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.GiangVienRepository;

@Service
public class GiangVienService {
	private GiangVienRepository giangVienRepository;
	
	public GiangVienService(GiangVienRepository giangVienRepository) {
		this.giangVienRepository = giangVienRepository;
	}
	
}
