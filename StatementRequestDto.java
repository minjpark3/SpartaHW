package com.sparta.springweek01.domain;

import lombok.Getter;

@Getter
public class StatementRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;
}
