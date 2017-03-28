package com.sales.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;
import com.sales.repositories.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productsRepository;

	public List<Product> ShowAll() {

		List<Product> products = new ArrayList<Product>();
		products.addAll((List<Product>) productsRepository.findAll());

		return products;

	}

	public Product save(Product product) {
		return productsRepository.save(product);
	}

}
