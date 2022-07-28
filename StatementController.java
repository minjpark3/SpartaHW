package com.sparta.springweek01.controller;

import com.sparta.springweek01.domain.Statement;
import com.sparta.springweek01.domain.StatementRepository;
import com.sparta.springweek01.domain.StatementRequestDto;
import com.sparta.springweek01.service.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StatementController {

    private final StatementRepository statementRepository;
    private final StatementService statementService;

    @PostMapping("/api/post")//@RequestBody 날아오는 녀석을 여기에 제대로 넣어줭
    public Statement createStatement(@RequestBody StatementRequestDto requestDto) {
        Statement statement = new Statement(requestDto);
        return statementRepository.save(statement);
    }

    @PutMapping("/api/post/{id}")//@RequestBody 날아오는 녀석을 여기에 제대로 넣어줭
    public Long updateStatement(@PathVariable Long id, @RequestBody StatementRequestDto requestDto){
        statementService.update(id,requestDto);
        return id;
    }

    @GetMapping("/api/post")
    public List<Statement> getStatements() {
        return statementRepository.findAllByOrderByModifiedAtDesc();
    }
    @DeleteMapping("/api/post/{id}")//@PathVariable 경로에 있는 변수
    public Long deleteStatement(@PathVariable Long id) {
        statementRepository.deleteById(id);
        return id;
    }

}