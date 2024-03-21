package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.DauDiemRepository;

@Service
public class DauDiemService {
	private DauDiemRepository dauDiemRepository;
	
	public DauDiemService(DauDiemRepository dauDiemRepository) {
		this.dauDiemRepository = dauDiemRepository;
	}
}
