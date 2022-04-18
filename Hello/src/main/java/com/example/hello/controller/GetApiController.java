package com.example.hello.controller;
import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping("/hello")   // http://localhost:8080/api/get/hello
    // 주로 path와 value를 많이 사용한다.
    public String getHello(){
        return "get Hello";
    }

    @RequestMapping(path="/hi", method = RequestMethod.GET) // http://localhost:8080/api/get/hi
    // "/hi"만 쓰면 get, post, put, delete 다 동작가능
    public String hi(){
        return "hi";
    }

    // 주소에는 대문자를 쓰지 않기 때문에 구분하기 위해서 -(dash)를 쓴다
    // path-variable에는 변화하는 값을 계속 받을 수 있도록 한다.
    // path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println("PathVariable : "+name);
        return name;
    }

    // pathVariable에 들어갈 값을 정해주면 pahtName으로 전달되어서 사용 가능
    @GetMapping("/path-variable2/{name}")
    public String pathVariable2(@PathVariable(name = "name") String pathName){
        System.out.println("PathVariable2 :"+pathName);
        return pathName;
    }

    // http://localhost:8080/api/get/query-param?user=leena&email=leena@gmail.com
    @GetMapping(path="query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(@RequestParam String name, @RequestParam String email, @RequestParam int age){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+ email+" "+age;
    }
    // Map으로 받으면 무엇이 들어올 지 모른다. 뭐든지 다 받게 된다.
    // 명시적으로 받을 때는 위와같이 하는 것이 좋다.


    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        // Requestparam 어노테이션을 붙이지 않음!
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

    // 객체를 미리 정의한 다음에 getter를 사용해서 받는 것이 가장 좋다.
}
