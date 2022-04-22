package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // User의 Repository, 기본키 id index가 Long 타입임을 선언
                                                                    // JpaRepository를 상속받으면 기본적은 CRUD를 제공한다.

}
