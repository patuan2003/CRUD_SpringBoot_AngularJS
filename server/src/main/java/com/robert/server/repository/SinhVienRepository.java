package com.robert.server.repository;

import com.robert.server.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE SinhVien sv set sv.ten =?1, sv.tuoi=?2, sv.gioiTinh=?3, sv.chuyenNganh=?4 WHERE sv.id=?5")
    void updateSinhVien(String ten, Integer tuoi, Boolean gioiTinh, String chuyenNghanh, Long id);
}
