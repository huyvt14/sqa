package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.KiHoc;
import com.example.demo.repository.KiHocRepository;

@Service
public class KiHocService {
	private KiHocRepository kiHocRepository;
	
	public KiHocService(KiHocRepository kiHocRepository) {
		this.kiHocRepository =kiHocRepository;
	}
	@Transactional(readOnly = false)
	public ArrayList<KiHoc> layDanhSachKiHocChuaBatDau(){
		return kiHocRepository.layDanhSachKiHocChuaBatDau();
	}
	public KiHoc layKiHoc(int id) {
		return kiHocRepository.findById(id);
	}
	public KiHoc layKiHocHienTai(int id) {
		return kiHocRepository.findByDangHoc(id);
	}
}
