package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import com.example.demo.model.SinhVien;
import com.example.demo.model.Khoa;
import com.example.demo.model.SVKhoa;
import com.example.demo.service.KhoaService;
import com.example.demo.service.SVKhoaService;
import com.example.demo.service.SinhVienService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private SinhVienService sinhVienService;
    @Autowired
    private KhoaService khoaService;
    @Autowired
    private SVKhoaService svKhoaService;
    
    @GetMapping("/list")
    public String listSinhVien(Model model) {
        List<SinhVien> sinhViens = sinhVienService.listAll();
        model.addAttribute("sinhViens", sinhViens);
        return "list_student";
    }
    @GetMapping("/add")
    public String addSinhVienForm(Model model) {
        List<Khoa> khoas = khoaService.listAllKhoa();
        if(khoas.size()>0) {
        	System.out.println(khoas.size());
        	System.out.println(khoas.get(0).getDanhSachMonHoc().toString());
        }
        model.addAttribute("khoas", khoas);
        model.addAttribute("sinhVienKhoa", new SVKhoa());
        return "new_student";
    }

    @PostMapping("/save")
    public String saveSinhVien(@ModelAttribute("sinhVienKhoa") SVKhoa sinhVienKhoa) {
    	SinhVien sinhVien = sinhVienKhoa.getSinhVien();
        sinhVienService.saveStudent(sinhVien); // Đảm bảo rằng bạn có một sinhVienService để lưu đối tượng SinhVien

        // Gán đối tượng SinhVien đã lưu vào trường sinhVien của đối tượng SVKhoa
        sinhVienKhoa.setSinhVien(sinhVien);

        // Tiếp tục lưu đối tượng SVKhoa vào cơ sở dữ liệu
        svKhoaService.saveStudent(sinhVienKhoa);
        return "redirect:/list";
    }
    @GetMapping("/delete/{id}")
    @Transactional
    public String deleteSinhVien(@PathVariable int id) {
    	SVKhoa sinhVienKhoa = svKhoaService.getStudentById(id);
    	svKhoaService.deleteBySinhVienId(id);
        sinhVienService.deleteStudent(id);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String updateStudent(@PathVariable int id, Model model) {
    	SVKhoa sinhVienKhoa = svKhoaService.getStudentById(id);
        List<Khoa> khoas = khoaService.listAllKhoa();
            model.addAttribute("sinhVienKhoa", sinhVienKhoa);
            model.addAttribute("khoas", khoas);
        return "new_student";
    }

}

