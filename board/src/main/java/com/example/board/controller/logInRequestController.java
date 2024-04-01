package com.example.board.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.logInDtoRequest;

@RestController
@RequestMapping("/api/v1/auth")
public class logInRequestController {
    @PostMapping("/sign-in")
    public String email(
        @RequestBody logInDtoRequest dto
    ) {
        return "전송한 데이터 : " + dto.toString();
    }
}
