package com.example.demo.model;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "monhoc")
public class MonHoc {
	@Id
	private int id;
	@Column(columnDefinition = "VARCHAR(11)", unique = true)
	private String maMonHoc;
	@Column( columnDefinition = "NVARCHAR(255)")
	private String ten;
	@Column(name = "sotinchi")
	private int soTinChi;
	
	public MonHoc() {
	}
	public MonHoc(int id) {
		this.id = id;
	}
}
