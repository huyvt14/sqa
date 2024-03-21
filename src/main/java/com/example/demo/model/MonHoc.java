package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MonHoc {
	@Id
	private int id;
	private String ten;
	
	public MonHoc() {
		
	}
	public MonHoc(int id) {
		this.id = id;
	}
}
