package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "hocki")
public class HocKi {
	@Id
	private int id;
	@Column( columnDefinition = "NVARCHAR(255)")
	private String ten;
	@Column(name = "mo_ta")
	private String moTa;
	@Column(name = "tt",  unique = true)
	private int stt;
	
	public HocKi() {
	}

	public HocKi(int id, String ten, int stt) {
		this.id = id;
		this.ten = ten;
		this.stt = stt;
	}
	
	
}
