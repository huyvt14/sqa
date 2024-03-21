package com.example.demo.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class GiangVien extends ThanhVien{
	private String maGV;
}
