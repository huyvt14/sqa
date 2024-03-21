package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class ThanhVien {
	@Id
	private int id;
	private String username;
	private String password;
	private String hoTen;
	private String soDienThoai;
	private String diaChi;
	private String ghiChu;
	private Date ngaySinh;
}
