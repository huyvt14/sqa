package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.MonHocRepository;

@Service
public class MonHocService {
	private MonHocRepository monHocRepository;
	
	public MonHocService (MonHocRepository monHocRepository) {
		this.monHocRepository = monHocRepository;
	}
}
