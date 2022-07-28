package com.sparta.springweek01.service;

import com.sparta.springweek01.domain.Statement;
import com.sparta.springweek01.domain.StatementRepository;
import com.sparta.springweek01.domain.StatementRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor//final로만들때 자동 생성자!만들어줭
@Service
public class StatementService {
    private final StatementRepository statementRepository;

    @Transactional//디비에 꼭 반영시켜줘
    public Long update(Long id, StatementRequestDto requestDto) {
        Statement statement = statementRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (statement.getPassword().equals(requestDto.getPassword()));
        statement.update(requestDto);
        return statement.getId();
    }
}