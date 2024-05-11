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
@Table(name = "kihoc")
public class KiHoc {
	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name="hoc_ki_id")
	private HocKi hocKi;
	@ManyToOne
	@JoinColumn(name="nam_hoc_id")
	private NamHoc namHoc;
	@Column( columnDefinition = "int DEFAULT 0", name="dang_hoc")
	private int dangHoc;
	
	public KiHoc() {
	}
	
	public KiHoc(int id) {
		this.id=id;
	}

	public KiHoc(int id, HocKi hocKi, NamHoc namHoc, int dangHoc) {
		this.id = id;
		this.hocKi = hocKi;
		this.namHoc = namHoc;
		this.dangHoc = dangHoc;
	}
	
}
