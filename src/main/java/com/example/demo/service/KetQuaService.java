package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.KetQuaRepository;

@Service
public class KetQuaService {
	private KetQuaRepository ketQuaRepository;
	
	public KetQuaService(KetQuaRepository ketQuaRepository) {
		this.ketQuaRepository = ketQuaRepository;
	}
}
