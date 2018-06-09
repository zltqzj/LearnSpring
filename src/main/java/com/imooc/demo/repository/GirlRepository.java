package com.imooc.demo.repository;

import com.imooc.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {

    // 通过年龄来查下
    public List<Girl> findByAge(Integer age);
}
