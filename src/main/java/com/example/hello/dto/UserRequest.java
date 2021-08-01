package com.example.hello.dto;

public class UserRequest {

    private String name;
    private String email;
    private int age;
    //getter,setter가 있어야된다.
    //code->generate->getter and setter
    //lombok으로 만들수도 있다.
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //리턴하기 위하여 toString 오버라이드
    //toString 쓰면 자동완성이 된다
    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
