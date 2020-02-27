package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(value = "/v1/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Product save(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@RequestMapping(value = "/{barCode}", method = RequestMethod.GET)
	public Product findByBarCode(@PathVariable("barCode") String barCode) {
		return productService.findByBarCode(barCode);
	}
	
	@RequestMapping(value = "/{barCode}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("barCode") String barCode) {
		productService.delete(barCode);
	}
	
	@RequestMapping(value = "/{barCode}/addAmount", method = RequestMethod.POST)
	public Product addAmount(@PathVariable("barCode") String barCode,
							 @RequestParam("amount") Integer amount) {
		
		return productService.addAmount(barCode, amount);
	}
	
	@RequestMapping(value = "/{barCode}/subtractAmount", method = RequestMethod.POST)
		public Product subtractAmount(@PathVariable("barCode") String barCode,
									  @RequestParam("amount") Integer amount) {
		return productService.subtractAmount(barCode, amount);
	}
	
	
}
