package com.jisang.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// HTTP * localhost:4000/request-data/** 
@RequestMapping("/request-data")
public class RequestDataController {
    
    // @RequestParam() : GET, DELETE 처럼 URL로 데이터를 전송하는 메서드에서 Query String으로 지정된 데이터를 가져오기 위해 사용

    // HTTP GET localhost:4000/request-data/request-param
    @GetMapping("/request-param")
    // http://localhost:4000/request-data/request-param?userId=qwer&userName=gildong
    public String getRequestParam(
        @RequestParam(name="userId") String userId,
        // @RequestParam(name="userName", required = false) String userName => userName은 필수가 아니라는 뜻
        @RequestParam(name="userName", required = false) String userName,
        // @RequestParam int userAge의 name을 지정하지 않으면 알아서 찾음/ 받는 타입인 userAge의 값을 지정해줘야함
        @RequestParam() int userAge
    ){ 
        // return을 통해서 body에 표시해줌
        return "사용자 아이디" + userId + "/사용자 이름:" + userName + "/사용자 나이:" + userAge;
    }

    // @PathVariable() : 
    // 모든 HTTP 메서드에서 URL의 특정 패턴에 따라서 데이터를 추출하는 방식

}
