package com.example.demo_jpa.repository;

import com.example.demo_jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Override
    public List<User> findAll();




}

