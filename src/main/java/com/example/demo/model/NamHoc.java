package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class NamHoc {
	@Id
	private int id;
	private String ten;
	private String moTa;
}
