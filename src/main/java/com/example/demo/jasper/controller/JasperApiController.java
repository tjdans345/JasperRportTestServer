package com.example.demo.jasper.controller;

import com.example.demo.jasper.domain.entity.MemberEntity;
import com.example.demo.jasper.service.JasperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/jasper")
@RestController
public class JasperApiController {

    private final JasperService jasperService;

    @GetMapping
    public List<MemberEntity> getMemberList() {
        return jasperService.getMemberList();
    }

}
