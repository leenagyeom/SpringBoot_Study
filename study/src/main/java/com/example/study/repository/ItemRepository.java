package com.example.study.repository;

import com.example.study.model.entity.item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<item, Long> {
}
