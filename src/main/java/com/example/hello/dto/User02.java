package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User02 {
    private String name;
    private int age;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phone_number")
    private String phoneNumber;

    public User02(String name,int age,String phoneNumber){
        this.age = age;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public User02(){
        this.age = 0;
        this.name = null;
        this.phoneNumber = null;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    //오류
    //ObjectMapper를 활용하지만 get메소드가 있어서
    //get이 메소드명에서 빼야된다.
    // public User02 getDefaultUser(){
    //   return new User02("default",0,"010-1111-2222");
    //}

    @Override
    public String toString() {
        return "User02{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
