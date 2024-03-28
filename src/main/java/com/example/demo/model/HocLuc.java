package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "hocluc")
public class HocLuc {
	@Id
	private int id;
	private String ten;
	private String moTa;
}
