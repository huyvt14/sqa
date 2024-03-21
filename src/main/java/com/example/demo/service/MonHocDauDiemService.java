package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.model.MonHoc;
import com.example.demo.model.MonHocDauDiem;
import com.example.demo.repository.MonHocDauDiemRepository;

@Service
public class MonHocDauDiemService {
	private MonHocDauDiemRepository monHocDauDiemRepository;
	
	public MonHocDauDiemService(MonHocDauDiemRepository monHocDauDiemRepository) {
		this.monHocDauDiemRepository = monHocDauDiemRepository;
	}


}
