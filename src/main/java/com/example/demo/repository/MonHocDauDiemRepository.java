package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MonHoc;
import com.example.demo.model.MonHocDauDiem;

public interface MonHocDauDiemRepository extends JpaRepository<MonHocDauDiem, Integer>{

}
