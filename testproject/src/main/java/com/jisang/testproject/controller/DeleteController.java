package com.jisang.testproject.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Delete API
// 서버를 통해 리소스를 삭제 하기 위해 사용되는 API
// 일반적으로 @PathVariable을 통해 리소스 ID등을 받아 처리
@RestController
@RequestMapping("/api/v1/get-api")
public class DeleteController {

    // http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @DeleteMapping(value = "/delete/{variable}")
    public String DeleteVariable(@PathVariable String variable) {
        return variable;
    }

}