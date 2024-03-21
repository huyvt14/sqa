package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.NamHocRepository;

@Service
public class NamHocService {
	private NamHocRepository namHocRepository;
	
	public NamHocService(NamHocRepository namHocRepository) {
		this.namHocRepository = namHocRepository;
	}
}
