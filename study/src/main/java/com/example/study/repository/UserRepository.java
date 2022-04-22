package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> { // User의 Repository, 기본키 id index가 Long 타입임을 선언
                                                                    // JpaRepository를 상속받으면 기본적은 CRUD를 제공한다.

    Optional<User> findByAccount(String account); // findBy를 보고 select 문이라고 알게된다.
    Optional<User> findByEmail(String email);
    Optional<User> findByAccountAndEmail(String account, String email);
}
