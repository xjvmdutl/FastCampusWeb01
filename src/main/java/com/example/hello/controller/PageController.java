package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//HTML 페이지를 리턴하는 Controller
@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        //Content-Type:	text/html 이다.
        //리턴을 해주는 내용이 HTML파일이다.
        //String을 리턴하면 resource에서 해당 html파일을 찾아서 return한다.
        return "main.html";
    }

    //ResponseEntity

    @ResponseBody//객체를 만들어서 리턴하라는 어노테이션
    //Resource에서 안찾고 객체를 만들어서 Body에 담아 리턴
    @GetMapping("/user")
    public User user(){
        var user = new User();//타입 추론을 할수있는 간단한 타입
        user.setName("steve");
        user.setAddress("패스트 캠퍼스");
        //int 형은 디폴트가 0이고, String은 null이다.
        //null로 받고 싶을경우 Integer형으로 바꿔야된다.
        return user;
    }
}
