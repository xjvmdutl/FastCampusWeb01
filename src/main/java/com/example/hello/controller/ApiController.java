package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    //GetMapping으로 온 queryParam을 받는다
    //TEXT를 내려준다
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;
    }

    //JSON을 내려준다
    //JSON을 요청받을걸 그대로 리턴한다.
    @PostMapping("/json")
    public User json(@RequestBody User user){
        //아무것도 설정하지 않았기 떄문에 카멜케이스로 리턴한다.
        //phoneNumber를 리턴해준다.
        //동작 원리
        //req -> object mapper -> object -> method -> object mapper -> json -> response

        return user;
    }


    //응답이 리턴할 경우 200 OK를 리턴한다.
    //PUT 같은경우 201과 200두개다 내려준다.(리소스를 생성할경우 201)
    //ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user){
        //명확하게 HTTP 코드를 넣어줄수도 있으며, Body에 데이터도 넣어 준다.
        //해당 방법을 가장 선호하는 편이다.
        return ResponseEntity.status(HttpStatus.CREATED).body(user);//201을 넣어준다.//생성

    }

}
