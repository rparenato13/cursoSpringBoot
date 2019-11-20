package com.example.cursoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursoSpringBoot.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{

}
