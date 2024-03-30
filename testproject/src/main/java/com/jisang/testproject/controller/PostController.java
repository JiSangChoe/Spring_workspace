package com.jisang.testproject.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jisang.testproject.data.dto.MemberDTO;

// Post API
// 리소스를 추가하기 위해 사용되는 API
// @PostMapping : POST API를 제작하기 위해 사용되는 어노테이션
// @RequestMapping + POST method의 조합
// 일반적으로 추가하고자 하는 Resource를 http body에 추가하여 서버에 요청
// 그렇기 때문에 @RequestBody를 이용하여 body에 담겨있는 값을 받아야함

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    // http://localhost:8080/api/v1/post-api/default
    @PostMapping(value = "/default")
    public String postMethod() {
        return "Hello World!";
    }

    // http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

    /*
    param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
     */

        return sb.toString();
    }

    // DTO 사용
    // key와 value가 정해져 있지만, 받아야할 파라미터가 많을 경우 DTO 객체를 사용한 방식
    // http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }

}