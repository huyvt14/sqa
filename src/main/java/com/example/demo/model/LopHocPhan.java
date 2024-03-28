package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class LopHocPhan {
	@Id
	private int id;
	private String ten;
	@ManyToOne
	@JoinColumn(name = "monhockihoc_id")
	private MonHocKiHoc monHocKiHoc;
}
