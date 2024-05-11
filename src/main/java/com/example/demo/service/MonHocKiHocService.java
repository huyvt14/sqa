package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.MonHocKiHoc;
import com.example.demo.repository.MonHocKiHocRepository;

@Service
public class MonHocKiHocService {
	private MonHocKiHocRepository monHocKiHocRepository;
	
	public MonHocKiHocService(MonHocKiHocRepository monHocKiHocRepository) {
		this.monHocKiHocRepository = monHocKiHocRepository;
	}
	
//	@Transactional(readOnly = false)
//	public ArrayList<MonHocKiHoc> layDanhMonHocCuaKiHocGanNhat(int id_kihoc){
//		return monHocKiHocRepository.layDanhMonHocCuaKiHocGanNhat(id_kihoc);
//	}
	
	@Transactional(readOnly = false)
	public ArrayList<MonHocKiHoc> timkiemMonHocTheoKiHocVaTen(int id_kihoc, String tuKhoa){
		return monHocKiHocRepository.timkiemMonHocTheoKiHocVaTen(id_kihoc, tuKhoa);
	}
	
}
