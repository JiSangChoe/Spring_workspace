package com.jisang.basic.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/validation")
    public String jwtValidate(
        @RequestBody String jwt 
    ){
        return basicService.jwtValidate(jwt);
    }

    @GetMapping("/authentication/principal")
    public String authenticationPrincipal(
        @AuthenticationPrincipal String username 
    ) {
        return "접근 주체 : " + username;
    }

}
