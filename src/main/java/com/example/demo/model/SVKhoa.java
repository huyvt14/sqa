package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class SVKhoa {
	@Id
	private int id;
	private String nienKhoa;
	@ManyToOne
	@JoinColumn(name = "khoa_id")
	private Khoa khoa;
	@ManyToOne
	@JoinColumn(name = "sinh_vien_id")
	private SinhVien sinhVien;
	private boolean dangHoc;
}
