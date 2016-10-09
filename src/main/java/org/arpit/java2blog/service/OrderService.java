package org.arpit.java2blog.service;

import java.util.List;
import org.arpit.java2blog.dao.OrderDAO;
import org.arpit.java2blog.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
public class OrderService {

	@Autowired
	OrderDAO orderDao;
	
	@Transactional
	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}
	@Transactional
	public List<Order> getOrdersBetween(String start, String end) {
		return orderDao.getOrdersBetween(start,end);
	}

	@Transactional
	public Order getOrder(int id) {
		return orderDao.getOrder(id);
	}

	@Transactional
	public void addOrder(Order order) {
		orderDao.addOrder(order);
	}

	@Transactional
	public void updateOrder(Order order) {
		orderDao.updateOrder(order);

	}

	@Transactional
	public void deleteOrder(int id) {
		orderDao.deleteOrder(id);
	}
}
