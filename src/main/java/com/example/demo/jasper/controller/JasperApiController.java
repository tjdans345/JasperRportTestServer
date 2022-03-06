package com.example.demo.jasper.controller;

import com.example.demo.jasper.domain.entity.MemberEntity;
import com.example.demo.jasper.service.JasperService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
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

    @GetMapping("/{format}")
    public String generateReport(@PathVariable String format, @RequestParam("title") String title) throws JRException, FileNotFoundException {
       return jasperService.exportReport(format, title);
    }

}
