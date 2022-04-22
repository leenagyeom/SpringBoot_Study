package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data // 객체사용
      // toString으로 깔끔한 결과를 확인할 수 있음
@AllArgsConstructor // 모든 매개변수를 가지는 생성자도 생성
@NoArgsConstructor
@Entity
//@Table(name = "user") // User 이름과 Database의 table 이름이 같으면 선언하지 않아도 됨
public class User {

    // @Column(name = "id"); // DB의 컬럼명과 같으면 선언하지 않아도 자동으로 매칭된다.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 어떤식으로 키를 관리할 지 설정
    private Long id;    // Bigint = Long
    private String account;
    private String email;

    // JPA의 Entity 및 column은 자동으로 camel case를 DB의 sname case로 매칭해준다.
    private String phoneNumber;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    // 1 : N
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderDetail> orderDetailList;

}
