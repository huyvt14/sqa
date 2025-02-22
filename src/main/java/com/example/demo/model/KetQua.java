package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ketqua")
public class KetQua {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "monhocdaudiem_id")
    private MonHocDauDiem monHocDauDiem;
    private float diem;
    private String ghiChu;
}
