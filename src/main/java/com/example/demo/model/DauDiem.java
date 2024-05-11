package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="daudiem")
public class DauDiem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column( columnDefinition = "NVARCHAR(255)")
	private String ten;
	@Column(name = "mo_ta")
	private String moTa;
	
	public DauDiem() {
		
	}
	public DauDiem(String ten) {
		this.ten = ten;
	}
	public DauDiem(int id, String ten) {

		this.id = id;
		this.ten = ten;
	}

}
