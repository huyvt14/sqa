package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.MonHoc;

public interface MonHocRepository extends JpaRepository<MonHoc, Integer>{
    MonHoc findById(int id);
}
