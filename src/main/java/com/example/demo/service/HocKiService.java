package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.HocKiRepository;

@Service
public class HocKiService {
	private HocKiRepository hocKiRepository;
	
	public HocKiService(HocKiRepository hocKiRepository) {
		this.hocKiRepository = hocKiRepository;
	}
}
