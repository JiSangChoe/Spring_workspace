package com.example.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.logInDtoResponse;

@RestController
@RequestMapping("/api/v1/auth")
public class logInResponseController {
    @PostMapping("sign-in")
    public ResponseEntity<logInDtoResponse> getResponseDto() {
        ResponseEntity<logInDtoResponse> response = ResponseEntity.status(200).body(new logInDtoResponse("SU", "Success"));
        return response;
    }
}
