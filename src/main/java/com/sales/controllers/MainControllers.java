package com.sales.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String addProducte(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);

		return "addProduct";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") @Valid Product product, BindingResult result) {

		// , RedirectAttributes redirectAtributes, ModelMap map,
		// HttpServletRequest request

		if (result.hasErrors()) {
			System.out.println("Tem Erros");
			return "addProduct";
		} else {

			System.out.println("Nao Tem Erros");
			productsService.save(product);

			return "redirect:showProducts";
		}

	}

}
