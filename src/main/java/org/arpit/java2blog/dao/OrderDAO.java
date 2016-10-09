package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Order> getAllOrders() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Order> orderList = session.createQuery("from Order").list();
		return orderList;
	}

	public List<Order> getOrdersBetween(String start, String end) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Order> orderList = session.createQuery("from Order where date >='"+start+"'and date <='" +end+"'").list();
		return orderList;
	}
	
	public Order getOrder(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Order order = (Order) session.load(Order.class, new Integer(id));
		return order;
	}

	public Order addOrder(Order order) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(order);
		return order;
	}

	public void updateOrder(Order order) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(order);
	}

	public void deleteOrder(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Order p = (Order) session.load(Order.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
