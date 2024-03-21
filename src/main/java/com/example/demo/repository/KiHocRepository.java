package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.KiHoc;

public interface KiHocRepository extends JpaRepository<KiHoc, Integer>{
	ArrayList<KiHoc> findAll();
}
