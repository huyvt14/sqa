package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class DangKiHoc {
	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name = "sv_khoa_id")
	private SVKhoa svKhoa;
	@ManyToOne
	@JoinColumn(name = "lop_hoc_phan_id")
	private LopHocPhan lopHocPhan;
	@OneToMany
	@JoinColumn(name = "ket_qua_id")
	private KetQua[] danhSachKetQua;
	private float diemTBM;
	private String diemTBChu;
}
