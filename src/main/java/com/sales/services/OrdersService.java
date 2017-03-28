package com.sales.services;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Order;
import com.sales.repositories.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;

	public List<Order> ShowAll() {

		List<Order> orders = new ArrayList<Order>();
		orders.addAll((List<Order>) ordersRepository.findAll());

		return orders;
	}

	public Order save(Order order) {
		//Pass the date into Order Date
		order.setOrderDate(DateFormated());

		return ordersRepository.save(order);
	}
	
	public String DateFormated(){
		// Formating Date into String
		String dateFormated;
		Format formatter;
		Date date = new Date();
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		return dateFormated = formatter.format(date);
	}

}
