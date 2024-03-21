package com.example.demo.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class SinhVien extends ThanhVien{
	private String maSv;
	private String lopChuyenNganh;
}
