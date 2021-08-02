package com.example.hello.controller;

import com.example.hello.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/put")
public class PutApiController {

    @PutMapping("/{userId}")
    public PutRequestDto put(@RequestBody PutRequestDto requestDto, @PathVariable(name = "userId") Long id){
        //CarList가 안들어 왔다
        //스네이크 케이스라서
        //클래스에 전체적인 룰을 준다.
        //JsonNaming 어노테이션을 통해 해당 클래스에 모든 변수에 Rule을 적용시켜줄수 있다.
        System.out.println(requestDto);
        //RestController의 경우 Object자체를 리턴시킬경우 스프링 부트 자체에서 오브젝트 메퍼를 통해 오브젝트로 바꿔준다.
        return requestDto;
    }


}
