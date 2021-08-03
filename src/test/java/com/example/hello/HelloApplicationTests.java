package com.example.hello;

import com.example.hello.dto.User02;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("============");
		//Text JSON -> Object
		//Object -> Text JSON
		//controller req JSON(text) -> object
		//response object -> JSON(text)

		var objectMapper = new ObjectMapper();

		//object -> text
		var user = new User02("steve",10,"010-1111-2222");
		var text = objectMapper.writeValueAsString(user);//value를 String으로
		System.out.println(text);
		//문제 발생 -> object는 Get메소드를 따라간다(getter 생성)
		//Object mapper가 object를 변경시 Get메소드를 활용하는것을 알수 있다.

		//text -> object
		var objectUser = objectMapper.readValue(text,User02.class);//(JSON 택스트, 들어갈 클래스)
		//에러 발생 -> 생성자가 없기때문(디폴트 생성자가 없다)
		//ObjectMapper가 동작하기 위해서는 디폴트 생성자가 있어야된다.
		//ObjectMapper를 활용하고 있는 클래스에서 get이라는 단어를 포함된 메소드는 존재하면 안된다.
		System.out.println(objectUser);
	}

}
