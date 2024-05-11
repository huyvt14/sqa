package com.example.demo.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.CauHinhController;
import com.example.demo.model.HocKi;
import com.example.demo.model.KiHoc;
import com.example.demo.model.MonHoc;
import com.example.demo.model.MonHocKiHoc;
import com.example.demo.model.NamHoc;
import com.example.demo.service.DauDiemService;
import com.example.demo.service.KiHocService;
import com.example.demo.service.MonHocDauDiemService;
import com.example.demo.service.MonHocKiHocService;
import com.example.demo.service.MonHocService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Test_CauHinhController {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
    private KiHocService kiHocService;    
	@MockBean
    private MonHocDauDiemService monHocDauDiemService;   
	@MockBean
    private MonHocKiHocService monHocKiHocService;
	@MockBean
    private MonHocService monHocService;
	@MockBean
    private DauDiemService dauDiemService;
    @InjectMocks
    private CauHinhController cauHinhController ;
    
    @Test
//    test @GetMapping("/cauhinh/chonmonhoc")
    public void testXuLyChonMonHoc() throws Exception {
    	NamHoc nh = new NamHoc(1, "2022-2023");
        NamHoc nh2 = new NamHoc(2, "2023-2024");
		HocKi hk1 = new HocKi(1, "học kỳ 1" ,1);
		HocKi hk2 = new HocKi(2, "học kỳ 2" ,3);
		HocKi hk3 = new HocKi(3, "học kỳ hè" ,2);
		KiHoc kiHoc1 = new KiHoc(4, hk1, nh2, 0);
		KiHoc kiHoc2 = new KiHoc(5, hk2, nh2, 0);
		KiHoc kiHoc3 = new KiHoc(6, hk3, nh2, 0);
		
		KiHoc kiHocDau = new KiHoc(2, hk2, nh, 1);
		ArrayList<KiHoc> dsKiHocChuaBatDau = new ArrayList<>();
		dsKiHocChuaBatDau.add(kiHoc1); dsKiHocChuaBatDau.add(kiHoc3); dsKiHocChuaBatDau.add(kiHoc2);
        
		ArrayList<MonHocKiHoc> listMonHocKiHoc = new ArrayList<>();
		MonHoc mh1 = new MonHoc(1, "INT125", "phân tích thiết kế", 2);
		MonHoc mh2 = new MonHoc(2, "INT12", "cơ sở dữ liệu", 3);
		MonHoc mh3 = new MonHoc(3, "INT124", "giải tích", 3);
		
		MonHocKiHoc mhkh3 = new MonHocKiHoc(9,kiHoc1,mh1);
		MonHocKiHoc mhkh1 = new MonHocKiHoc(10,kiHoc1,mh2);
		MonHocKiHoc mhkh2 = new MonHocKiHoc(11,kiHoc1,mh3);
		listMonHocKiHoc.add(mhkh1); listMonHocKiHoc.add(mhkh2); listMonHocKiHoc.add(mhkh3);
		
        mockMvc.perform(get("/cauhinh/chonmonhoc"))
                .andExpect(status().isOk()) 
                .andExpect(view().name("ch_chonmonhoc")) 
                .andExpect(request().sessionAttribute("listMonHocKiHoc",listMonHocKiHoc))
                .andExpect(request().sessionAttribute("listkihoc", dsKiHocChuaBatDau))
                .andExpect(request().sessionAttribute("kihoc", kiHocDau.getId()))
                .andExpect(request().sessionAttribute("tenmonhoc", ""));
    	
	}
}
