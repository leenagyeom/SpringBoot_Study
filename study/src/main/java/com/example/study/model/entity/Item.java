package com.example.study.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String content;

    // 1 : N
    // LAZY = 지연로딩(추천), EAGER = 즉시로딩
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // Lazy : 메소드로 get method로 호출하지 않는 이상, 연관관계가 설정된 테이블에 대해 select 하지 않겠다.
    // Eager (1:1) : 연관관계가 설정된 모든 테이블에 대해 join이 일어난다.
    // 데이터가 많은 테이블에 eager가 걸려있으면 성능 저하나 누락의 위험이 있다.
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item") // OrderDetail의 item에 mapping 시키겠다
    private List<OrderDetail> orderDetailList;
}
