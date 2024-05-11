package com.example.demo.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.DauDiem;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class Test_DauDiemRepo {
	@Autowired
	private DauDiemRepository dauDiemRepository;
	
	@Test
	public void test() {
//		lấy đầu điểm theo tên đầu điểm 
//		dauDiemRepository.findByTen()
		DauDiem ddMongDoi = new DauDiem(1,"chuyên cần");
		DauDiem dd = dauDiemRepository.findByTen("chuyên cần");
		assertEquals(ddMongDoi, dd);
	}
	
	@Test
	public void test1() {
//		lấy đầu điểm theo tên đầu điểm không đầy đủ
//		dauDiemRepository.findByTen()
		DauDiem ddMongDoi = null;
		DauDiem dd = dauDiemRepository.findByTen("c");
		assertEquals(ddMongDoi, dd);
	}
	
	@Test
	public void test2() {
//		lấy đầu điểm theo tên đầu điểm null
//		dauDiemRepository.findByTen()
		DauDiem ddMongDoi = null;
		DauDiem dd = dauDiemRepository.findByTen(null);
		assertEquals(ddMongDoi, dd);
	}
	
}
