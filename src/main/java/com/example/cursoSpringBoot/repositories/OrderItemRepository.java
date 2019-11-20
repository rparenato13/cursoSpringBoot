package com.example.cursoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursoSpringBoot.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
