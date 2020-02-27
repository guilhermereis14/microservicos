package com.example.demo.service;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	private static Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product save(Product product) {
				
		return productRepository.save(product);
		
	}
	
	public Product findByBarCode(String barCode) {
		return productRepository.findByBarCode(barCode);
	}
	
	public void delete(String barCode0) {
		
	}
	
	public Product findById(Long id) {
		return null;
	}
	
	public Product addAmount(String barCode, Integer amount) {
		logger.info("m=addAmount, barCode={}, amount={}", barCode, amount);
		Product product = findByBarCode(barCode);
		product.setAmount(product.getAmount() + amount);
		
		return productRepository.save(product);
	}
	
	public Product subtractAmount(String barCode, Integer amount) {
		logger.info("m=subtractAmount, barCode={}, amount={}", barCode, amount);
		Product product = findByBarCode(barCode);
		if (product.getAmount() < amount)
		throw new ServiceException("Quantidade indisponível no estoque");
		product.setAmount(product.getAmount() - amount);
		
		return productRepository.save(product);
	}
	
	
	
	
	
	
}


