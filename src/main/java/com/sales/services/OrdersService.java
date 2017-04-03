package com.sales.services;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.repositories.CustomersRepository;
import com.sales.repositories.OrdersRepository;
import com.sales.repositories.ProductsRepository;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private CustomersRepository customersRepository;

	public List<Order> ShowAll() {

		List<Order> orders = new ArrayList<Order>();
		orders.addAll((List<Order>) ordersRepository.findAll());

		return orders;
	}

	
	// Method to format date to pass into the database format yyyy/mm/dd
	public Order save(Order order) {
		// Pass the date into Order Date
		order.setOrderDate(DateFormated());

		setQuantity(order);

		return ordersRepository.save(order);
	}

	public String DateFormated() {
		// Formating Date into String
		String dateFormated;
		Format formatter;
		Date date = new Date();
		formatter = new SimpleDateFormat("yyyy-MM-dd");

		return dateFormated = formatter.format(date);
	}

	//Set a new qty for stock
	public void setQuantity(Order order) {
		Product product = productsRepository.findOne(order.getProd().getpId());
		int newQty = product.getQtyInStock() - order.getQty();

		// Set the new Stock
		product.setQtyInStock(newQty);
		// Save the product
		productsRepository.save(product);
	}

	public String ValidateOrder(Order order) {
		String msq = "";

		//find a product
		Product product = productsRepository.findOne(order.getProd().getpId()); 
		
		//find a customer
		Customer customer = customersRepository.findOne(order.getCust().getcId()); 

		if (product == null) { //set a msq for not exist product
			msq += " No such product: " + order.getProd().getpId();
		} else { // if product exist will get stock
			int qty = product.getQtyInStock() - order.getQty();

			if (qty < 0) {
				msq += " Quantity too Large: Product stock = " + product.getQtyInStock();
			}
		}

		if (customer == null) { //set a msq for not exist customer
			msq += " No such customer: " + order.getCust().getcId();
		}

		return msq;
	}

}
