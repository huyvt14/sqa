package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "monhoc_kihoc")
public class MonHocKiHoc {
	@Id
	private int id;
	private int nhomMonHoc;
	@ManyToOne
	@JoinColumn(name = "kihoc_id")
	private KiHoc kiHoc;
	@ManyToOne
	@JoinColumn(name = "monhoc_id")
	private MonHoc monHoc;
}
