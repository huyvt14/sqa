package com.example.demo.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class QuanTriVien extends ThanhVien{
	private String maQTV;
}
