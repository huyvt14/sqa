package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Khoa {
	@Id
	private int id;
	private String ten;
	private String moTa;
	@OneToMany
	@JoinColumn(name = "khoa_id")
	private MonHoc[] danhSachMonHoc;
	@OneToMany
	@JoinColumn(name = "khoa_id")
	private GiangVien[] danhSachGiangVien;
}
