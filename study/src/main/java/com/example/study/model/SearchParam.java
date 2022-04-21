package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // 모든 매개변수를 가지는 생성자가 추가된다.
public class SearchParam {

    private String account;
    private String email;
    private int page;
}

// structure에 변수만 남기고 @Data 어노테이션을 달아준다.
// 경고가 뜨는데 build.gradle과 해당 파일에 추가된다.
// File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors 에서 Enable annotation processing 설정