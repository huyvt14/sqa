package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.MonHocKiHoc;


public interface MonHocKiHocRepository extends JpaRepository<MonHocKiHoc, Integer>{
//  @Procedure(name = "laydanhmonhoccuakihocgannhat", procedureName="sqa1.laydanhmonhoccuakihocgannhat")
//    ArrayList<MonHocKiHoc> layDanhMonHocCuaKiHocGanNhat(@Param("id_kihoc")int id_kihoc);
    
    @Procedure(name = "timkiemmonhoctheokihocvaid", procedureName ="sqa1.timkiemmonhoctheokihocvaid")
    ArrayList<MonHocKiHoc> timkiemMonHocTheoKiHocVaTen(@Param("id_kihoc")int id_kihoc,@Param("tukhoa") String tuKhoa);
}
