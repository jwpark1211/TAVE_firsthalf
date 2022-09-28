package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    //=@PathVariable과 @RequestParam을 활용한 DELETE Method=//
    //localhost:8080/api/v1/delete-api/{String값}
    @DeleteMapping(value = "/{variable}")
    public String DeleteVariable(@PathVariable String variable){
        return variable;
    }

    //=@RequestParam을 활용한 Delete Method=//
    //localhost:8080/api/v1/delete-api/request1?email=value
    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email){
        return "e-mail : "+ email;
    }
}
