package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    // 아래와 같음 @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    // POST는 HTML에서 <Form>태그를 쓰거나 ajax 검색에서 사용된다.
    // 검색 파라미터가 많다는 것
    // http post 통신에서 body에 data를 집어넣어넣어서 보낸다.
    // json, xml, multipart-form / text-plain 형태
    // produces = {"application-json"} 으로 지정해줄 수 있는데 기본이 json
    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }
}
