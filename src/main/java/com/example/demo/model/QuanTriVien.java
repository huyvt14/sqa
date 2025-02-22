package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "quantrivien")
public class QuanTriVien{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column( unique = true)
    private String maQTV;
    @Column( unique = true)
    private String username;
    private String password;
    private String hoTen;
    private String soDienThoai;
    private String diaChi;
    private String ghiChu;
    private Date ngaySinh;
}
