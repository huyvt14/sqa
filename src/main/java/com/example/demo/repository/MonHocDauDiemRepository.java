package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.MonHocDauDiem;

public interface MonHocDauDiemRepository extends JpaRepository<MonHocDauDiem, Integer>{
	@Procedure(name = "laydaudiemtrongso", procedureName="sqa1.laydaudiemtrongso")
    ArrayList<MonHocDauDiem> layDauDiemTrongSo(@Param("id_monhoc")int id_monhoc);
	ArrayList<MonHocDauDiem> findByKiHocIdAndMonHocId(int idkiHoc, int idmonHoc);
}
