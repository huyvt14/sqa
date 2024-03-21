package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class MonHocKiHoc {
	@Id
	private int id;
	private int nhomMonHoc;
	@ManyToOne
	@JoinColumn(name = "ki_hoc_id")
	private KiHoc kiHoc;
	@ManyToOne
	@JoinColumn(name = "mon_hoc_id")
	private MonHoc monHoc;
}
