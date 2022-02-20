package com.example.demo.jasper.service;


import com.example.demo.jasper.domain.entity.MemberEntity;
import com.example.demo.jasper.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JasperService {

    private final MemberRepository memberRepository;

    public List<MemberEntity> getMemberList() {
        return memberRepository.findAll();
    }


}
