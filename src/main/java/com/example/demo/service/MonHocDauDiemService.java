package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.MonHocDauDiem;
import com.example.demo.repository.MonHocDauDiemRepository;

@Service
public class MonHocDauDiemService {
	private MonHocDauDiemRepository monHocDauDiemRepository;
	
	public MonHocDauDiemService(MonHocDauDiemRepository monHocDauDiemRepository) {
		this.monHocDauDiemRepository = monHocDauDiemRepository;
	}
	@Transactional(readOnly = false)
	public ArrayList<MonHocDauDiem> layDauDiemTrongSo(int id_monhoc){
		return monHocDauDiemRepository.layDauDiemTrongSo(id_monhoc);
	}
	@Transactional
	public void capNhatThayDoi(ArrayList<MonHocDauDiem> monHocDauDiem) {
		for (MonHocDauDiem mhdd : monHocDauDiem) {
			monHocDauDiemRepository.save(mhdd);
		}
	}
	public ArrayList<MonHocDauDiem> layDauDiemMonHocTheoKi(int idkiHoc, int idmonHoc){
		return monHocDauDiemRepository.findByKiHocIdAndMonHocId(idkiHoc, idmonHoc);
	}
	public void xoaDauDiemMonHoc(int id) {
		monHocDauDiemRepository.deleteById(id);
	}
}
