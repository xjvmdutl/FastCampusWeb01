package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")//실제로 get을 붙히진 않는다
public class GetApiController {
    //GET 메소드 만들기 1) GETMAPPING
    //GetMapping에서 가장 많이 쓰는것은 Path와 Value이다.
    //기본값으로 넣게되면은 value값으로 지정되며 Path가 된다.
    //명시가능 , path로 경로지정 가능
    //각 메소드 마다 Mapping이 존재하고 ,RequestMapping에 method를 지정할 필요가 없어졋다.
    @GetMapping(path = "/hello") //http://localhost:9090/api/get/hello
    public String getHello(){
        return "get Hello";
    }

    //이전에 사용했던방식
    //get, Post모두 받아서 문제가 있다
    //해결 방안 path지정 후 method 값을 지정해준다
    @RequestMapping(path = "/hi", method = RequestMethod.GET)//http://localhost:9090/api/get/hi
    public String hi(){
        return "hi";
    }

    //http://localhost:9090/api/get 해당 주소까지 고정
    //주소에는 대문자쓰지 않고 - 로 쓴다
    //사용자의 요청에 따라 변화되는 값을 받는다.
    //변화하는 값이 들어 올때마다 주소를 계속 추가 할수 없기 때문에 해당 방법을 사용한다.
    //http://localhost:9090/api/get/path-variable/{name}
    //@GetMapping(path = "/path-variable/{name}")
    //public String pathVarialbe(@PathVariable String name){//변화되는 name값을 받을 매개변수를 써야된다
    //주의 사항 : GetMapping에서 사용한 pathVariable 값과 매개변수에서 받는 name은 똑같아야 한다.
    //만약 사용자 지정을 하고 싶을경우에는 다음과 같이 사용
    @GetMapping(path = "/path-variable/{name}")
    public String pathVarialbe(@PathVariable(name = "name") String pathName,String name){
        System.out.println("PathVariable : "+pathName);
        return pathName;
    }

    //?q=intellij&oq=int&aqs=chrome.0.69i59j69i57j69i59j0i131i433i512l2j69i60l3.2039j0j9&sourceid=chrome&ie=UTF-8
    //QueryParam : ? 뒤에 붙어있는 Key,Value로 이루어진 파라미터, & 연산자와 = 연산자로 이루어져있다.
    //key = value로 이루어 지고 뒤에 추가로 key = value를 하기위해서는 & 연산자를 사용해야한다.
    //주소 설계 : http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    //Map으로 받을 수 있다.
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){//queryParam에 Map 형식으로 받는다
        //@RequestParam Annotation을 붙혀야 한다.
        //Map으로 받는것의 문제점 : 키값이 어떤것이 들어오는지 알수가 없다..
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");
            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });
        return sb.toString();
    }

    //명시적으로 변수로 받는다.
    //각 어노테이션을 키값마다 붙힌다.
    //주의할점, data 타입을 다르게 보냇을 경우에는 에러가 발생한다.(400에러,클라이언트의 에러이다.)
    //문제점, data가 증가할 수록 RequestParam을 추가할수 없다-> 해결 : dto형태로 매핑해서 받는다.
    @GetMapping(path = "query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name + " " + email + " " + age;
    }

    @GetMapping(path = "query-param03")
    public String queryParam03(UserRequest userRequest){
        //주의할점 : RequestParam Anotation을 붙히지 않는다
        //why? SpringBoot에서의 동작원리 때문에
        //매개변수로 객체가 들어오게 되면 QueryParam을 주소들을 SpringBoot에서 판단하여 해당 객체에서 이름 매칭을 해준다.
        //반드시 getter,setter를 구현을 해 두어야 한다.
        //queryParam에 userRequest에없는 변수를 보낼경우에는 Mapping되지 않는다.
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }
}
