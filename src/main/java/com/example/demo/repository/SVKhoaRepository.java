package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SVKhoa;

public interface SVKhoaRepository extends JpaRepository<SVKhoa, Integer>{

	public SVKhoa findBySinhVienId(int id);

	public void deleteBySinhVienId(int id);

}
