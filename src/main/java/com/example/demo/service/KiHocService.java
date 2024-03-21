package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.model.KiHoc;
import com.example.demo.repository.KiHocRepository;

@Service
public class KiHocService {
	private KiHocRepository kiHocRepository;
	
	public KiHocService(KiHocRepository kiHocRepository) {
		this.kiHocRepository =kiHocRepository;
	}
	public ArrayList<KiHoc> getKiHoc(){
		return kiHocRepository.findAll();
	}
}
