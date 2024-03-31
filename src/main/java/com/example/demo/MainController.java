package com.example.demo;

import java.util.ArrayList;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

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

@Controller
public class MainController {
	
	@GetMapping("")
	public String trangChu() {
		return "trangchu";
	}
	
}
