package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "lophocphan")
public class LopHocPhan {
	@Id
	private int id;
	private String ten;
	private int nhomMonHoc;
	@ManyToOne
	@JoinColumn(name = "monhockihoc_id")
	private MonHocKiHoc monHocKiHoc;
}
