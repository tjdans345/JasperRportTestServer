package com.example.demo.jasper.service;


import com.example.demo.jasper.domain.entity.MemberEntity;
import com.example.demo.jasper.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class JasperService {

    private final MemberRepository memberRepository;

    public String exportReport(String reportFormat) throws JRException, FileNotFoundException {
        var path = "C:\\Users\\user\\Desktop\\reporttest";
        var userList = memberRepository.findAll();
        // load file and compile it
        File file = ResourceUtils.getFile("classpath:firstTest.jrxml"); // 이 파일안에 데이터가 어떻게 매핑되는지를 먼저 파악하기

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(userList);
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Meteor");
        JasperPrint report = JasperFillManager.fillReport(jasperReport, parameters , dataSource);

        // equalsIgnoreCase 대소문자 구분없이 비교함
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(report, path+"\\members.html");
        }

        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(report, path+"\\members.pdf");
        }

        return "report generated in path : " + path;

    }

    public List<MemberEntity> getMemberList() {
        return memberRepository.findAll();
    }


}
