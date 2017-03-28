package com.sales.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomersRepository;

@Service
public class CustomersService {

	@Autowired
	private CustomersRepository customersRepository;

	public List<Customer> ShowAll() {

		List<Customer> customers = new ArrayList<Customer>();
		customers.addAll((List<Customer>) customersRepository.findAll());

		return customers;
	}

	public Customer save(Customer customer) {
		return customersRepository.save(customer);
	}

}
