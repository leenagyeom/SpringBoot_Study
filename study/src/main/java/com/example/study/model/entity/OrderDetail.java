package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"user", "item"}) // 연관관계 설정 시 상호참조를 exclude 시켜준다.
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;


    // N(order) : 1(user) - 자신을 중심으로 생각해야한다.
    @ManyToOne
    private User user; // user_id, hybernate로 설정할때는 반드시 객체이름으로 작성해야한다.

    @ManyToOne
    private Item item;
}
