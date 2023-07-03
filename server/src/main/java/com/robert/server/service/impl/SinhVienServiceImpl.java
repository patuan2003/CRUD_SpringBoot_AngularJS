package com.robert.server.service.impl;

import com.robert.server.entity.SinhVien;
import com.robert.server.repository.SinhVienRepository;
import com.robert.server.service.SinhVienService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienServiceImpl implements SinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Override
    public List<SinhVien> getAll() {
        return sinhVienRepository.findAll();
    }

    @Override
    public void save(SinhVien request) {
        sinhVienRepository.save(request);
    }

    @Transactional
    @Modifying
    @Override
    public void update(Long id, SinhVien request) {
        sinhVienRepository.updateSinhVien(request.getTen(), request.getTuoi(), request.getGioiTinh(), request.getChuyenNganh(), id);
    }

    @Override
    public void remove(Long id) {
        sinhVienRepository.deleteById(id);
    }
}
