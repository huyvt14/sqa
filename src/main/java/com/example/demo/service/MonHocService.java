package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.MonHoc;
import com.example.demo.repository.MonHocRepository;

@Service
public class MonHocService {
	private MonHocRepository monHocRepository;

	public MonHocService (MonHocRepository monHocRepository) {
		this.monHocRepository = monHocRepository;
	}
	public MonHoc layMonHoc(int id) {
		return monHocRepository.findById(id);
	}
	public void capNhatThayDoi(MonHoc monHoc) {
			monHocRepository.save(monHoc);
	}
}
