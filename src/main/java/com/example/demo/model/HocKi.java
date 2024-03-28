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
	@Column(name = "ten")
	private String ten;
	@Column(name = "mo_ta")
	private String moTa;
}
