package com.example.cursoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursoSpringBoot.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
