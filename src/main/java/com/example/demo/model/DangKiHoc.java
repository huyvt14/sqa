package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "dangkihoc")
public class DangKiHoc {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "svkhoa_id")
    private SVKhoa svKhoa;
    @ManyToOne
    @JoinColumn(name = "lophocphan_id")
    private LopHocPhan lopHocPhan;
    @OneToMany
    @JoinColumn(name = "ketqua_id")
    private KetQua[] danhSachKetQua;
    private float diemTBM;
    private String diemTBChu;
}
