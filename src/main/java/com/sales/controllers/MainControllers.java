package com.sales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Product;
import com.sales.services.ProductsService;

@Controller
public class MainControllers {

	// @Autowired
	// private CustomerService customerService;

	@Autowired
	private ProductsService productsService;

	// @RequestMapping(value = "/getCustomers", method = RequestMethod.GET)
	// public String getCustomers(Model model) {
	//
	// List<Customer> allCustomers = customerService.ShowAll();
	// model.addAttribute("customerForm", allCustomers);
	//
	// return "listCustomers";
	// }

	@RequestMapping(value = "/showProducts", method = RequestMethod.GET)
	public String showProducts(Model model) {

		List<Product> allProducts = productsService.ShowAll();
		// for (Address a : allAddresses) {
		//
		// for (Customer c : a.getCustomersWithThisAddress()) {
		// System.out.println("--->" + c.getcName());
		// }
		//
		// System.out.println(a.getTown());
		//
		// }

		model.addAttribute("productsForm", allProducts);

		return "listProducts";
	}

}
