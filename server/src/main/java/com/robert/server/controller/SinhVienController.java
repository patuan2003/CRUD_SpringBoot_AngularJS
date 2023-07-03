package com.robert.server.controller;

import com.robert.server.entity.SinhVien;
import com.robert.server.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sinh-vien/")
@CrossOrigin
public class SinhVienController {

    @Autowired
    private SinhVienService service;

    @GetMapping("hien-thi")
    public List<SinhVien> display() {
        return service.getAll();
    }

    @PostMapping("save")
    public void save(@RequestBody SinhVien request) {
        service.save(request);
    }

    @PutMapping("update/{id}")
    public void updateSinhVien(@PathVariable("id") Long id, @RequestBody SinhVien request) {
        request.setId(id);
        service.save(request);
    }

    @DeleteMapping("remove/{id}")
    public void removeSinhVien(@PathVariable("id") Long id) {
        service.remove(id);
    }

}
