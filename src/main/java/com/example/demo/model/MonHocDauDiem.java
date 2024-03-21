package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class MonHocDauDiem {
	@Id
	private int id;
	private String title;
	@ManyToOne
	@JoinColumn(name = "dau_diem_id")
	private DauDiem dauDiem;
	private float tile;
}
