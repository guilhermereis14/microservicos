package com.example.demo.repository;

import com.example.demo.model.ProductEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, String>{
		
	ProductEntity findByIsbn(String isbn);

}
