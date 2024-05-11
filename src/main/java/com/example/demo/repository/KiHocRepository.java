package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.KiHoc;

public interface KiHocRepository extends JpaRepository<KiHoc, Integer>{
	@Procedure(name = "laydanhsachcackihocchuadienra", procedureName="sqa1.laydanhsachcackihocchuadienra")
    ArrayList<KiHoc> layDanhSachKiHocChuaBatDau();
//	KiHoc findById(int id);
	KiHoc findByDangHoc(int giatri);
}
