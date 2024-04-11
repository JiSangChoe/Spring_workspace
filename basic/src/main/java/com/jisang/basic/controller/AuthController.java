package com.jisang.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jisang.basic.service.BasicService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final BasicService basicService;

    @GetMapping("/{principal}")
    public String getJwt(
        @PathVariable("principal") String principal
    ) {
        return basicService.getJwt(principal);
    }

}
