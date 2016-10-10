package org.arpit.java2blog.controller;

import java.util.List;
import org.arpit.java2blog.model.Order;
import org.arpit.java2blog.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/getAllOrders", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Order> getOrders() {		
		List<Order> listOfOrders = orderService.getAllOrders();
		return listOfOrders;
	}
	
	@RequestMapping(value = "/getOrdersBetween/{start}/{end}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Order> getOrdersBetween(@PathVariable("start") String start,@PathVariable("end") String end) {		
		List<Order> listOfOrders = orderService.getOrdersBetween(start,end);
		return listOfOrders;
	}

	@RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Order getOrderById(@PathVariable int id) {
		return orderService.getOrder(id);
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST, headers = "Accept=application/json")
	public Order addOrder(@RequestBody Order order) {	
		return orderService.addOrder(order);		
	}

	@RequestMapping(value = "/updateOrder", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateOrder(@RequestBody Order order) {
		orderService.updateOrder(order);
	}

	@RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteOrder(@PathVariable("id") int id) {
		orderService.deleteOrder(id);		
	}	
}
