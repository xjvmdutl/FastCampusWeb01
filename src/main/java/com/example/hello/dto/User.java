package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

//방법2
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
//Response를 내릴때 null값 같이 내리고 싶지 않는값들이 있을경우 @JsonInclude 어노테이션을 활용한다.
@JsonInclude(JsonInclude.Include.NON_NULL)//속성 지정가능,//NULL값이나 빈값들을 포함 안할수도 있다.
public class User {

    private Integer age;
    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    private String name;
    //@JsonProperty("phone_number")
    //방법 1
    private String phoneNumber;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
