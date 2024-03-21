package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class KiHoc {
	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name="hoc_ki_id")
	private HocKi hocKi;
	@ManyToOne
	@JoinColumn(name="nam_hoc_id")
	private NamHoc namHoc;
	private boolean dangHoc;
	
	public KiHoc() {
	}
	
	public KiHoc(int id) {
		this.id=id;
	}
}
