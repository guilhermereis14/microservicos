package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>{
		
	Product findByBarCode(String barCode);

}
