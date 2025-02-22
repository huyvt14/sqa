package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.MonHocDauDiem;
import com.example.demo.repository.MonHocDauDiemRepository;

@Service
public class MonHocDauDiemService {
    private MonHocDauDiemRepository monHocDauDiemRepository;
    
    
    public MonHocDauDiemService(MonHocDauDiemRepository monHocDauDiemRepository) {
        this.monHocDauDiemRepository = monHocDauDiemRepository;
    }
    
    @Transactional(readOnly = false)
    public ArrayList<MonHocDauDiem> layDauDiemTrongSo(int id_monhoc, int id_kihocdc){
        return monHocDauDiemRepository.layDauDiemTrongSo(id_monhoc, id_kihocdc);
    }
    
    @Transactional
    public void capNhatThayDoi(ArrayList<MonHocDauDiem> monHocDauDiem) {
        for (MonHocDauDiem mhdd : monHocDauDiem) {
            monHocDauDiemRepository.save(mhdd);
        }
    }

    public void xoaDauDiemMonHoc(int id) {
        monHocDauDiemRepository.deleteById(id);
    }
    
    public void xoaTatCaMonHocDauDiem(int idKiHoc, int idMonHoc) {
        monHocDauDiemRepository.deleteAllByKiHocIdAndMonHocId(idKiHoc, idMonHoc);
    }
}
