package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.model.KiHoc;
import com.example.demo.model.MonHocKiHoc;
import com.example.demo.repository.MonHocKiHocRepository;

@Service
public class MonHocKiHocService {
	private MonHocKiHocRepository monHocKiHocRepository;
	
	public MonHocKiHocService(MonHocKiHocRepository monHocKiHocRepository) {
		this.monHocKiHocRepository = monHocKiHocRepository;
	}
	public ArrayList<MonHocKiHoc> getMonHocKiHocTheoKi(KiHoc kiHoc){
		return monHocKiHocRepository.findByKiHoc(kiHoc);
	}
	
}
