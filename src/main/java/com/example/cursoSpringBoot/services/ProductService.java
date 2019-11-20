package com.example.cursoSpringBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cursoSpringBoot.entities.Product;
import com.example.cursoSpringBoot.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository categoryRepository;

	public List<Product> findAll() {
		return categoryRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = categoryRepository.findById(id);
		return obj.get();
	}
	
}
