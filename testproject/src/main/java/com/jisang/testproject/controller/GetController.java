package com.jisang.testproject.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jisang.testproject.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String getHello() {
        return "Hello World";
    }
    
    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        return "Flature";
    }

    // http://localhost:8080/api/v1/get-api/variable1/{String의값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    // 위의 코드와의 차이점은 {variable}와 var가 같지 않으니 이렇게 표현
    // http://localhost:8080/api/v1/get-api/variable2/{String의값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable ("variable")String var) {
        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1?
    // name = flature&
    // email = thinkground.flature@gmail.com&
    @GetMapping(value = "/request1")
    public String getRequestParm1(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organization) {
            return name + " " + email + " " + organization;
        }

    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

    /*
    param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
    */

        return sb.toString();
    }

    // http://localhost:8080/api/v1/get-api/request3?name=flature&email=thinkground.flature@gmail.com&organization=thinkground
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        //return memberDTO.getName() + " " + memberDTO.getEmail() + " " + memberDTO.getOrganization();
        return memberDTO.toString();
    }
}
