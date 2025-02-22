package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "namhoc")
public class NamHoc {
    @Id
    private int id;
    private String ten;
    private String moTa;
    
    public NamHoc() {

    }

    public NamHoc(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }
    
    
}

