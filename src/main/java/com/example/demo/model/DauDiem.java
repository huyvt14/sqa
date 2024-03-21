package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DauDiem {
	@Id
	private int id;
	private String ten;
	@Column(name = "mo_ta")
	private String moTa;
	@Column(name = "trong_so")
	private int trongSo;
}
