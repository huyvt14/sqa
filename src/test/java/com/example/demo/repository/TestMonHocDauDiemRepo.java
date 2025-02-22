package com.example.demo.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.DauDiem;
import com.example.demo.model.HocKi;
import com.example.demo.model.KiHoc;
import com.example.demo.model.MonHoc;
import com.example.demo.model.MonHocDauDiem;
import com.example.demo.model.NamHoc;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestMonHocDauDiemRepo {
    
    @Autowired
    private MonHocDauDiemRepository monHocDauDiemRepository;
    ArrayList<MonHocDauDiem> dsMonHocDauDiemMongDoi = new ArrayList<>();
    ArrayList<MonHocDauDiem> dsMonHocDauDiemDaXoa = new ArrayList<>();
    
    @Before
    public void mongDoiTest1() {
//      kết quả mong đợi của test 1
        NamHoc nh2 = new NamHoc(1, "2022-2023");    
        HocKi hk1 = new HocKi(1, "học kỳ 1" ,1);
        KiHoc kiHoc1 = new KiHoc(1, hk1, nh2, 0);
        MonHoc mh2 = new MonHoc(2, "INT12", "cơ sở dữ liệu", 3);
        
        DauDiem dd1 = new DauDiem(1,"chuyên cần");
        DauDiem dd2 = new DauDiem(2,"kiểm tra giữa kì");
        DauDiem dd3 = new DauDiem(4,"kết thúc học phần");

        MonHocDauDiem mhdd1 = new MonHocDauDiem(25,dd1, kiHoc1, 10, mh2);
        MonHocDauDiem mhdd2 = new MonHocDauDiem(26,dd2, kiHoc1, 20, mh2);
        MonHocDauDiem mhdd3 = new MonHocDauDiem(27,dd3, kiHoc1, 70, mh2);
        
        this.dsMonHocDauDiemMongDoi.add(mhdd1);
        this.dsMonHocDauDiemMongDoi.add(mhdd2);
        this.dsMonHocDauDiemMongDoi.add(mhdd3);
    }
    
    @Test
    public void test1() {
//      kiểm tra lấy danh sách đầu điểm của môn học
//      monHocDauDiemRepository.layDauDiemTrongSo()
        ArrayList<MonHocDauDiem> dsMonHocDauDiem = new ArrayList<>();
        dsMonHocDauDiem = monHocDauDiemRepository.layDauDiemTrongSo(2, 2);
        assertEquals(this.dsMonHocDauDiemMongDoi, dsMonHocDauDiem);
    }
    
    @Test
    public void test2() {
//      kiểm tra xóa môn học đầu điểm
//      monHocDauDiemRepository.deleteAllByKiHocIdAndMonHocId()
        ArrayList<MonHocDauDiem> dsMonHocDauDiemDaXoa = new ArrayList<>();
        dsMonHocDauDiemDaXoa = monHocDauDiemRepository.deleteAllByKiHocIdAndMonHocId(1, 2);
        assertEquals(this.dsMonHocDauDiemMongDoi, dsMonHocDauDiemDaXoa);
    }
    
    @After
    public void restoreData() {
        for (MonHocDauDiem monHocDauDiem : dsMonHocDauDiemDaXoa) {
            if (monHocDauDiem != null && monHocDauDiemRepository.existsById(monHocDauDiem.getId())) {
                monHocDauDiemRepository.save(monHocDauDiem);
            }
        }
    }
    
    @Before
    public void mongDoiTest3() {
        this.dsMonHocDauDiemMongDoi.clear();
//      kết quả mong đợi của test 3
        NamHoc nh2 = new NamHoc(2, "2023-2024");    
        HocKi hk1 = new HocKi(2, "học kỳ 2" ,3);
        KiHoc kiHoc1 = new KiHoc(5, hk1, nh2, 0);
        MonHoc mh2 = new MonHoc(2, "INT12", "cơ sở dữ liệu", 3);
        
        DauDiem dd1 = new DauDiem(1,"chuyên cần");
        DauDiem dd2 = new DauDiem(2,"kiểm tra giữa kì");
        DauDiem dd3 = new DauDiem(3,"thực hành");
        DauDiem dd4 = new DauDiem(4,"kết thúc học phần");

        MonHocDauDiem mhdd1 = new MonHocDauDiem(117,dd1, kiHoc1, 10, mh2);
        MonHocDauDiem mhdd2 = new MonHocDauDiem(118,dd2, kiHoc1, 20, mh2);
        MonHocDauDiem mhdd3 = new MonHocDauDiem(119,dd3, kiHoc1, 20, mh2);
        MonHocDauDiem mhdd4 = new MonHocDauDiem(120,dd4, kiHoc1, 50, mh2);
        
        this.dsMonHocDauDiemMongDoi.add(mhdd1); this.dsMonHocDauDiemMongDoi.add(mhdd2); this.dsMonHocDauDiemMongDoi.add(mhdd3);
        this.dsMonHocDauDiemMongDoi.add(mhdd4);
    }
    
    @Test
    public void test3() {
//      kiểm tra lấy danh sách đầu điểm của môn học (giống test 1)
//      monHocDauDiemRepository.layDauDiemTrongSo()
        ArrayList<MonHocDauDiem> dsMonHocDauDiem = new ArrayList<>();
        dsMonHocDauDiem = monHocDauDiemRepository.layDauDiemTrongSo(2, 5);
        assertEquals(this.dsMonHocDauDiemMongDoi, dsMonHocDauDiem);
    }
}
