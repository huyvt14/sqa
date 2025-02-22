package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "monhoc_daudiem")
public class MonHocDauDiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "daudiem_id")
    private DauDiem dauDiem;
    private int trongSo ;
    @ManyToOne
    @JoinColumn(name = "kihoc_id")
    private KiHoc kiHoc;
    @ManyToOne
    @JoinColumn(name = "monhoc_id")
    private MonHoc monHoc;
    
    public MonHocDauDiem() {
        
    }
    public MonHocDauDiem(int id,DauDiem dauDiem, KiHoc kiHoc, int trongSo, MonHoc monHoc) {
        this.id=id;
        this.dauDiem = dauDiem;
        this.kiHoc = kiHoc;
        this.trongSo = trongSo;
        this.monHoc =monHoc;
    }
    public MonHocDauDiem(DauDiem dauDiem, KiHoc kiHoc, int trongSo, MonHoc monHoc) {
        this.dauDiem = dauDiem;
        this.kiHoc = kiHoc;
        this.trongSo = trongSo;
        this.monHoc =monHoc;
    }
}
