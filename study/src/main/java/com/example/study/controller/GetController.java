package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // URL : http://localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path ="/getMethod")
    public String getRequest(){
        return "Hi getMethod";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam(name = "pw") String pass) {
    // http://localhost:8080/api/getParameter?id=1234&pw=yyyydd

        String pw = "bbbb";

        System.out.println("id : " + id);
        System.out.println("pass : " + pass);

        return id + pass;

    }

    // http://localhost:8080/api/multiparameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/getmultiparameter")
    public SearchParam getMultiparameter(SearchParam searchParam){ // Request Parameter가 많아질 때 객체로 받는 게 좋다!
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam;
    }
}