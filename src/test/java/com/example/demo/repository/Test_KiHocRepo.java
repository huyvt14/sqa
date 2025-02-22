package com.example.demo.repository;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.HocKi;
import com.example.demo.model.KiHoc;
import com.example.demo.model.NamHoc;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class Test_KiHocRepo {
    @Autowired
    private KiHocRepository kiHocRepository;
    private ArrayList<KiHoc> dsKiHocMongDoi;
    private KiHoc kiHocDangHocMongDoi;
    
    @Before
    public void mongDoiTest1() {
//      kết quả mong đợi của test 1
        NamHoc nh2 = new NamHoc(2, "2023-2024");

        HocKi hk1 = new HocKi(1, "học kỳ 1" ,1);
        HocKi hk2 = new HocKi(2, "học kỳ 2" ,3);
        HocKi hk3 = new HocKi(3, "học kỳ hè" ,2);
        
        KiHoc kiHoc1 = new KiHoc(4, hk1, nh2, 0);
        KiHoc kiHoc2 = new KiHoc(5, hk2, nh2, 0);
        KiHoc kiHoc3 = new KiHoc(6, hk3, nh2, 0);
        
        this.dsKiHocMongDoi = new ArrayList<>();
        this.dsKiHocMongDoi.add(kiHoc1); this.dsKiHocMongDoi.add(kiHoc3);  this.dsKiHocMongDoi.add(kiHoc2);
    }
    @Test
    public void test1() {
//      test lấy danh sách các kì học chưa bắt đầu
//      kiHocRepository.layDanhSachKiHocChuaBatDau()
        
        ArrayList<KiHoc> dsKiHoc = new ArrayList<>();
        dsKiHoc = kiHocRepository.layDanhSachKiHocChuaBatDau();
        assertEquals(dsKiHocMongDoi, dsKiHoc);
    }
    
    @Before
    public void mongDoiTest2() {
//      kết quả mong đợi của test 2
        NamHoc nh1 = new NamHoc(1, "2022-2023");
        HocKi hk2 = new HocKi(2, "học kỳ 2" ,3);
        this.kiHocDangHocMongDoi = new KiHoc(2, hk2, nh1, 1);
    }
    
    @Test
    public void test2() {
//      lấy kì học đang học có trường đang học là 1
//      kiHocRepository.findByDangHoc(1)
        
        KiHoc kiHocDangHoc = kiHocRepository.findByDangHoc(1);
        assertEquals(kiHocDangHoc,this.kiHocDangHocMongDoi);
    }
    
}
