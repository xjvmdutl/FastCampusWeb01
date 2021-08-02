package com.example.hello.controller;

import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/post")
public class PostApiController {

    @PostMapping("/")
    public void post(@RequestBody Map<String,Object> requestData){
        //Post방식에서는 Body에 데이터를 심기 때문에 RequestBody 어노테이션이 필요하다.
        requestData.forEach((key, value) -> {
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });
    }

    //값을 받아서 전달받기
    @PostMapping("/request_dto")
    public void requestDto(@RequestBody PostRequestDto requestData){
        //Post객체로 받는건 반드시 RequestBody 어노테이션으로 있어야 되며,
        //JSON 데이터의 Key에 해당되는 것들이 객체의 변수로 있어야된다.
        //Java에서는 카멜케이스로 작성되지만 ,스네이크 케이스에서는 형태기 다르기 때문에 못찾는다.
        //NULL값이 들어온다(phone_number는 디폴트가 카멜케이스라서)
        //ObjectMapper 라이브러리에서 따로 이름을 지정하지 않을경우 스네이크케이스를 따르기 때문에 못찾는다.
        //해결법 -> JsonProperty 어노테이션 활용
        //단 변수마다 일일이 달아줘야 된다.
        //SpringApplication에서 설정하거나,properties로 설정할수도 있다.
        System.out.println(requestData);
    }
}
