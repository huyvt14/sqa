package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.KiHoc;
import com.example.demo.model.MonHocKiHoc;


public interface MonHocKiHocRepository extends JpaRepository<MonHocKiHoc, Integer>{
	ArrayList<MonHocKiHoc>  findByKiHoc(KiHoc kiHoc);
}
