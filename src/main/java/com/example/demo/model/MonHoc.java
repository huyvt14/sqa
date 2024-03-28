package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "monhoc")
public class MonHoc {
	@Id
	private int id;
	private String ten;
	@OneToMany
	@JoinColumn(name = "monhoc_id")
	private MonHocDauDiem[] listMonHocDauDiem ;
	
	public MonHoc() {
	}
	public MonHoc(int id) {
		this.id = id;
	}
}
