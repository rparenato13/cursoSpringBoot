package com.example.cursoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursoSpringBoot.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

}
