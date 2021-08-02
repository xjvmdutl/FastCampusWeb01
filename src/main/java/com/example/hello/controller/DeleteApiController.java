package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delete")
public class DeleteApiController {

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account){
        //delete 메소드는 여러가지 값을 받지 않는다.
        //오류가 없을 경우 항상 같은 응답을 받는다
        //GET과 동일하지만 안에동작하는 로직이 다르다.
        //데이터가 없어도 에러를 알려주지 않는다 -> 리소스의 삭제이기 때문에 데이터가 없어도 200 상태값을 리턴한다.
        System.out.println(userId);
        System.out.println(account);
    }
}
