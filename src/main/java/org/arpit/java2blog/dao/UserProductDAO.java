package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.UserProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<UserProduct> getAllUserProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<UserProduct> userProductList = session.createQuery("from UserProduct").list();
		return userProductList;
	}

	public UserProduct getUserProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserProduct userProduct = (UserProduct) session.load(UserProduct.class, new Integer(id));
		return userProduct;
	}

	public UserProduct addUserProduct(UserProduct userProduct) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(userProduct);
		return userProduct;
	}

	public void updateUserProduct(UserProduct userProduct) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(userProduct);
	}

	public void deleteUserProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserProduct p = (UserProduct) session.load(UserProduct.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
