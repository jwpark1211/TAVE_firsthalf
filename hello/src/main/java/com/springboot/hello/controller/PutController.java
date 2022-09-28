package com.springboot.hello.controller;

import com.springboot.hello.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    //** PUT과 PATCH는 서로 대체제와 같은 관계가 아니다. 확실한 정의를 알고 사용해야 한다.
    //** PUT은 멱등성의 조건을 완전히 만족할 수 있을 때만 사용하라.
    //** PUT 요청에는 항상 전체 리소스가 포함되어야 한다.

    //=@RequestBody와 Map을 활용한 Put Method=//
    //localhost:8080/api/v1/put-api/member
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //=@RequestBody와 DTO를 활용한 Put Method=//
    //localhost:8080/api/v1/put-api/member1
    //* toString()으로 보냈으므로 response가 String의 형태로 전달
    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

    //=@RequestBody와 DTO를 활용한 Put Method=//
    //localhost:8080/api/v1/put-api/member2
    //* Dto로 보냈으므로 response가 Json 형태로 전달
    @PutMapping(value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto;
    }

    //=ResponseEntity를 활용한 Put Method=//
    //* HttpEntity : 헤더와 바디로 구성된 HTTP 요청과 응답을 구성하는 역할을 수행
    //* ResponseEntity : 서버에 들어온 요청에 대해 응답 데이터를 구성해서 전달할 수 있게 함
    //localhost:8080/api/v1/put-api/member3
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED) //응답 코드 202
                .body(memberDto);
    }
}
