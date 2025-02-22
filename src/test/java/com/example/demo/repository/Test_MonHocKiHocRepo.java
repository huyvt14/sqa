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
import com.example.demo.model.MonHoc;
import com.example.demo.model.MonHocKiHoc;
import com.example.demo.model.NamHoc;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class Test_MonHocKiHocRepo {
    @Autowired
    private MonHocKiHocRepository monHocKiHocRepository;
    ArrayList<MonHocKiHoc> dsMonHocKiHocMongDoi;
    
    @Before
    public void mongDoiTest1() {
        this.dsMonHocKiHocMongDoi = new ArrayList<>();
        NamHoc nh2 = new NamHoc(2, "2023-2024");    
        HocKi hk1 = new HocKi(1, "học kỳ 1" ,1);
        KiHoc kiHoc1 = new KiHoc(4, hk1, nh2, 0);
        
        MonHoc mh1 = new MonHoc(1, "INT125", "phân tích thiết kế", 2);
        MonHoc mh2 = new MonHoc(2, "INT12", "cơ sở dữ liệu", 3);
        MonHoc mh3 = new MonHoc(3, "INT124", "giải tích", 3);
        
        MonHocKiHoc mhkh3 = new MonHocKiHoc(9,kiHoc1,mh1);
        MonHocKiHoc mhkh1 = new MonHocKiHoc(10,kiHoc1,mh2);
        MonHocKiHoc mhkh2 = new MonHocKiHoc(11,kiHoc1,mh3);
        this.dsMonHocKiHocMongDoi.add(mhkh1); this.dsMonHocKiHocMongDoi.add(mhkh2); this.dsMonHocKiHocMongDoi.add(mhkh3);
    }
    @Test
    public void test1() {
//      kiểm tra lấy danh sách môn học qua từ khóa và id kì học 
//      monHocKiHocRepository.timkiemMonHocTheoKiHocVaTen
//      đầu vào nội dung tìm kiếm null
        ArrayList<MonHocKiHoc> dsMonHocKiHoc = new ArrayList<>();
        dsMonHocKiHoc = monHocKiHocRepository.timkiemMonHocTheoKiHocVaTen(4, "");
        assertEquals(this.dsMonHocKiHocMongDoi, dsMonHocKiHoc);
    }
    
    @Test
    public void test2() {
//      kiểm tra lấy danh sách môn học qua từ khóa và id kì học 
//      monHocKiHocRepository.timkiemMonHocTheoKiHocVaTen
//      đầu vào nội dung tìm kiếm ""
        ArrayList<MonHocKiHoc> dsMonHocKiHoc = new ArrayList<>();
        dsMonHocKiHoc = monHocKiHocRepository.timkiemMonHocTheoKiHocVaTen(4, null);
        assertEquals(this.dsMonHocKiHocMongDoi, dsMonHocKiHoc);
    }
    
    @Test
    public void test3() {
//      kiểm tra lấy danh sách môn học qua từ khóa và id kì học 
//      monHocKiHocRepository.timkiemMonHocTheoKiHocVaTen
//      đầu vào nội dung tìm kiếm chữ thường
        ArrayList<MonHocKiHoc> dsMonHocKiHoc = new ArrayList<>();
        dsMonHocKiHoc = monHocKiHocRepository.timkiemMonHocTheoKiHocVaTen(4, "int124");
        
        ArrayList<MonHocKiHoc> dsMonHocKiHocMongDoi = new ArrayList<>();
        NamHoc nh2 = new NamHoc(2, "2023-2024");    
        HocKi hk1 = new HocKi(1, "học kỳ 1" ,1);
        KiHoc kiHoc1 = new KiHoc(4, hk1, nh2, 0);
        MonHoc mh = new MonHoc(3, "INT124", "giải tích", 3);
        MonHocKiHoc mhkh = new MonHocKiHoc(11,kiHoc1,mh);
        dsMonHocKiHocMongDoi.add(mhkh);
        
        assertEquals(dsMonHocKiHocMongDoi, dsMonHocKiHoc);
    }
}
