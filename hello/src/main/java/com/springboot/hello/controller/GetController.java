package com.springboot.hello.controller;

import com.springboot.hello.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    //=매개변수가 없는 GET Method=//
    //localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName(){
        return "Flature";
    }

    //=@PathVariable을 활용한 GET Method=//
    //localhost:8080/api/v1/get-api/variable1/{String값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    //=@PathVariable을 활용한 Get Method2=//
    //localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable")String var){
        return var;
    }

    //=@RequestParam을 활용한 Get Method=//
    // localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request1")
    public String getRequestParam1(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organization
    ){
        return name + " " + email + " " + organization;
    }

    //=@RequestParam을 활용한 Get Method2=//
    // localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //**DTO = Data Transfer Object의 약자, 각 클래스 및 인터페이스를 호출하면서 전달하는 매개변수로 사용되는 데이터 객체**//
    //=DTO 객체를 활용한 GET Method=//
    // localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request3") //** Json객체로 옮기고 싶다면 MemberDto 앞에 @RequestBodu를 붙일 것.
                                     //**그렇지 않으면 @RequestParam 처럼 동작함!
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }
}
