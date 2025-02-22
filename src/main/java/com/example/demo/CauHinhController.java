package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.DauDiem;
import com.example.demo.model.KiHoc;
import com.example.demo.model.MonHoc;
import com.example.demo.model.MonHocDauDiem;
import com.example.demo.model.MonHocKiHoc;
import com.example.demo.service.DauDiemService;
import com.example.demo.service.KiHocService;
import com.example.demo.service.MonHocDauDiemService;
import com.example.demo.service.MonHocKiHocService;
import com.example.demo.service.MonHocService;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class CauHinhController {
    private final KiHocService kiHocService;
    private final MonHocDauDiemService monHocDauDiemService;
    private final MonHocKiHocService monHocKiHocService;
    private final MonHocService monHocService;
    private final DauDiemService dauDiemService;
    
    
    public CauHinhController(KiHocService kiHocService, MonHocDauDiemService monHocDauDiemService,
            MonHocKiHocService monHocKiHocService, MonHocService monHocService, DauDiemService dauDiemService) {
        this.dauDiemService = dauDiemService;
        this.kiHocService = kiHocService;
        this.monHocDauDiemService = monHocDauDiemService;
        this.monHocKiHocService = monHocKiHocService;
        this.monHocService = monHocService;
    }
    
    @GetMapping("/cauhinh/chonmonhoc")
    public String xuLyChonMonHoc(HttpSession session) {
        ArrayList<KiHoc> listKiHoc = kiHocService.layDanhSachKiHocChuaBatDau();
        KiHoc kiHocDau = new KiHoc();
        ArrayList<MonHocKiHoc> listMonHocKiHoc = new ArrayList<>();
        if(listKiHoc.size()!=0) {
            kiHocDau = listKiHoc.get(0);
            listMonHocKiHoc = monHocKiHocService.timkiemMonHocTheoKiHocVaTen(kiHocDau.getId(), "");
        }
        session.setAttribute("listMonHocKiHoc", listMonHocKiHoc);
        session.setAttribute("listkihoc", listKiHoc);
        session.setAttribute("kihoc", kiHocDau.getId());
        session.setAttribute("tenmonhoc", "");
        return "ch_chonmonhoc";
    }
    
    @GetMapping("/cauhinh/ketquatimkiemmonhoc")
    public String xuLyTimMonHoc(@RequestParam("tenmonhoc") String tenmonhoc,
            @RequestParam("id_kihoc") int id_kihoc, HttpSession session) {
        tenmonhoc = tenmonhoc.toUpperCase().trim();
        session.setAttribute("tenmonhoc", tenmonhoc);
        ArrayList<MonHocKiHoc> listMonHocKiHoc = monHocKiHocService.timkiemMonHocTheoKiHocVaTen(id_kihoc, tenmonhoc);
        session.setAttribute("listMonHocKiHoc", listMonHocKiHoc);
        session.setAttribute("id_kihoc", id_kihoc);
        return "ch_chonmonhoc";
    }
    
    @GetMapping("/cauhinh/chinhsuadaudiemtrongso")
    public String xuLyTimMonHoc(@RequestParam("idmonhoc") int idmonhoc, HttpSession session) {
        MonHoc monHoc = new MonHoc();
        ArrayList<MonHocKiHoc> listMonHocKiHoc = (ArrayList<MonHocKiHoc>) session.getAttribute("listMonHocKiHoc");
        if(listMonHocKiHoc.size()>0) {
            monHoc =listMonHocKiHoc.get(0).getMonHoc();
        }
        int id_kihoc = (int) session.getAttribute("id_kihoc");
        ArrayList<MonHocDauDiem> listDauDiemMonHoc = monHocDauDiemService.layDauDiemTrongSo(idmonhoc,id_kihoc);
        session.setAttribute("listDauDiemMonHoc", listDauDiemMonHoc);
        session.setAttribute("id_monhoc", idmonhoc);
        session.setAttribute("monHocTieuDe", monHoc);
        return "ch_daudiemtrongso";
    }
    
    @Transactional
    @GetMapping("/cauhinh/capnhatdaudiemtrongso")
    public String xuLyCapNhatDauDiemTrongSo(@RequestParam("tendaudiem") ArrayList<String> listtendaudiem,
            @RequestParam("id") ArrayList<Integer> listid,
            @RequestParam("trongso") ArrayList<Integer> listtrongso, HttpSession session) {
        
        int kiHocCuaMonHocChinhSua =  (int) session.getAttribute("id_kihoc");
        ArrayList<MonHocDauDiem> listDauDiemMonHoc = (ArrayList<MonHocDauDiem>) session.getAttribute("listDauDiemMonHoc");
        if(listtendaudiem.size()>0 && listtrongso.size() >0) {
            try{
                MonHoc mh = monHocService.layMonHoc((Integer)session.getAttribute("id_monhoc"));
                ArrayList<MonHocDauDiem> listMHDD = new ArrayList<>();
                
                if(kiHocCuaMonHocChinhSua == listDauDiemMonHoc.get(0).getKiHoc().getId()) {
                    monHocDauDiemService.xoaTatCaMonHocDauDiem( kiHocCuaMonHocChinhSua, mh.getId());
                }
                for(int i=0;i < listtendaudiem.size(); ++i) {
                    DauDiem dd = dauDiemService.layDauDiem(listtendaudiem.get(i));
                    if(dd == null) {
                        dd = dauDiemService.luuVaLayRa(new DauDiem(listtendaudiem.get(i)));
                    }
                    KiHoc kiHocChinhSua = new KiHoc();
                    for(KiHoc kh: (ArrayList<KiHoc>) session.getAttribute("listkihoc")) {
                        if(kh.getId() == kiHocCuaMonHocChinhSua) {
                            kiHocChinhSua = kh;
                            break;
                        }
                    }
                    listMHDD.add(new MonHocDauDiem(dd, kiHocChinhSua, listtrongso.get(i), mh));
                }
                monHocDauDiemService.capNhatThayDoi(listMHDD);
                session.setAttribute("thongbao", "thanh cong");
                return "ch_chonmonhoc";
            }
            catch (Exception e) {
            }
        }
        session.setAttribute("thongbao", "không thành công");
        return "ch_daudiemtrongso";
    }
    
}
