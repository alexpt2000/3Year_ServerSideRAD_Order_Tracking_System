package com.sales.controllers;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sales.exceptions.ErrorMsg;
import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.services.CustomersService;
import com.sales.services.OrdersService;
import com.sales.services.ProductsService;

@Controller
@SessionAttributes(value = {"order", "product", "errorMgs"})
public class MainControllers {

	@Autowired
	private CustomersService customersService;

	@Autowired
	private ProductsService productsService;

	@Autowired
	private OrdersService ordersService;

	/*
	 * logout
	 * 
	 * This method force the logout
	 */
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		SecurityContextHolder.clearContext();
		session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		for (Cookie cookie : request.getCookies()) {
			cookie.setMaxAge(0);
		}

		return "redirect:login?logout";
	}

	/*
	 * Products
	 * 
	 * 
	 */
	@RequestMapping(value = "/showProducts", method = RequestMethod.GET)
	public String showProducts(Model model) {

		List<Product> allProducts = productsService.ShowAll();
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
			return "addProduct";
		} else {
			productsService.save(product);
			return "redirect:showProducts";
		}

	}

	/*
	 * Customers
	 * 
	 * 
	 */
	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	public String showCustomers(Model model) {

		List<Customer> allCustomers = customersService.ShowAll();
		model.addAttribute("customersForm", allCustomers);

		return "listCustomers";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String addCustomers(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "addCustomer";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomersPost(@ModelAttribute("customer") @Valid Customer customer, BindingResult result) {

		if (result.hasErrors()) {
			return "addCustomer";
		} else {
			customersService.save(customer);
			return "redirect:showCustomers";
		}

	}

	/*
	 * Orders
	 * 
	 * 
	 */
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String showOrders(Model model) {

		List<Order> allOrders = ordersService.ShowAll();
		model.addAttribute("ordersForm", allOrders);

		return "listOrders";
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
	public String addOrder(ModelMap model) {
		Order order = new Order();
		ErrorMsg errorMgs = new ErrorMsg();
		
		model.addAttribute("order", order);
		model.addAttribute("errorMgs", errorMgs);
		
		
		return "addOrder";
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public String addOrderPost(@ModelAttribute("order") @Valid Order order, BindingResult result, @ModelAttribute("errorMgs") ErrorMsg errorMgs) {

		if (result.hasErrors()) {
			return "addOrder";
		}

		int countStock = ordersService.CountStock(order);

		if (countStock < 0) {
			System.out.println("Estoque " + countStock);

			errorMgs.setMsg("Test Error");
			
			return "forward:showError";
		}

		ordersService.save(order);
		return "redirect:showOrders";

	}

	@RequestMapping(value = "/showError", method = RequestMethod.GET)
	public String showError(@ModelAttribute("errorMgs") ErrorMsg errorMgs, @ModelAttribute("order") Order order, HttpServletRequest h) {
		
		System.out.println(order.getProd().getpDesc());
		System.out.println(errorMgs.getMsg());
		
		return "showError";
	}

}
