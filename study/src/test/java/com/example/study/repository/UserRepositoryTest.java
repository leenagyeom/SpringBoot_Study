package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    // 대표적인 디자인 패턴, DI : Dependency Injection
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        // String sql = insert into user (%s, %s, %s) value (account, email, age); 쿼리문을 가지고 값들을 매칭시켜거 실행시켰는데
        // Object를 가지고 DB를 관리할 수 있게 도와주는 게 JPA

        User user = new User();
        // user.setId(); auto increment라서 자동증가라 삭제
        user.setAccount("TestUSer03");
        user.setEmail("TestUSer0@gmail.com");
        user.setPhoneNumber("010-3333-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : "+newUser);

    }

    @Test
    public void read(){ // 컨트롤러가 아니지만 CRUD와 RestAPI로 연결하면 가능
        Optional<User> user = userRepository.findById(2L); // 2L : Longtype, find : User 테이블을 list로 모두 가져오겠다.

        user.ifPresent(selectUser ->{
            if (selectUser.getId() == 2) {
                System.out.println("user : "+ selectUser);
                System.out.println("email : "+ selectUser.getEmail());
            }
        }); // selectUser가 Optional에 들어있으면 값을 꺼내서 println로 출력하겠다.
    }

    public void update(){

    }

    public void delete(){

    }

}
