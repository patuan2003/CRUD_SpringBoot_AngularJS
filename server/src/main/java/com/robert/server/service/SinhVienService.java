package com.robert.server.service;

import com.robert.server.entity.SinhVien;

import java.util.List;

public interface SinhVienService {
    List<SinhVien> getAll();

    void save(SinhVien request);

    void update(Long id, SinhVien request);

    void remove(Long id);
}
