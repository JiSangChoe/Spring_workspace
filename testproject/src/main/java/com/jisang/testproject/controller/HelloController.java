package com.jisang.testproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러(Controller)
// 모델(Model)과 뷰(View) 사이에서 브릿지 역할을 수행
// 앱의 사용자로부터 입력에 대한 응답으로 모델 및 뷰를 업데이트 하는 로직을 포함
// 사용자의 요청은 모두 컨트롤러를 통해 진행되어야 함
// 컨트롤러로 들어온 요청은 모델이 어떻게 처리할지 결정하여 모델로 요청을 전달함
// 예) 쇼핑물에서 상춤을 검색하면 그 키워드를 컨트롤러가 받아 모델과 뷰에 적절하게 입력을 처리하여 전달함

// @RequestMapping
// MVC의 핸들러 매핑(Handler Mapping)을 위해서 DefaultAnnotationHandlerMapping을 사용
// 클래스와 메소드의 RequestMapping을 통해 URL을 매핑하여 경로를 설정하여 해당 메소드에서 처리
// Value : url설정 , method : GET, POST, DELETE, PUT, PATCH 등

@RestController
public class HelloController {



    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello World!";
    }
}
