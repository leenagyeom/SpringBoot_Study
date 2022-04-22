package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.Assert;
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

    @Test
    public void update(){ // update하려면 특정 데이터를 select 먼저 해야한다.
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            // setId로 지정하게되면 findById로 찾은 데이터가 바뀌지 않고 setId로 찾은 데이터가 바뀐다. 주의!
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
            // id가 있는 지 먼저 찾고, 그 id의 row를 찾은 다음 update를 한다.
            // update 할 때는 바뀐 내용 + 원래 내용으로 다시 한번 update 된다.
            // JPA를 활용하면 object로 깔끔하게 관리할 수 있다.
        });
    }

    @Test
    public void delete(){
        Optional<User> user = userRepository.findById(1L);

        Assert.assertTrue(user.isPresent()); // JUnit 패키지의 asserttrue 메소드로 isPresent가 true일 때 통과된다.

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(1L);

        Assert.assertFalse(deleteUser.isPresent()); // false 여야 통과된다.

//        출력결과 확인
//        if(deleteUser.isPresent()){
//            System.out.println("데이터 존재 : " + deleteUser.get());
//        } else {
//            System.out.println("데이터 삭제 데이터 없음");
//        }

    }

}
