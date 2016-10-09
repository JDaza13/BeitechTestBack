package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DetailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Detail> getAllDetails() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Detail> detailList = session.createQuery("from Detail").list();
		return detailList;
	}

	public Detail getDetail(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Detail detail = (Detail) session.load(Detail.class, new Integer(id));
		return detail;
	}

	public Detail addDetail(Detail detail) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(detail);
		return detail;
	}

	public void updateDetail(Detail detail) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(detail);
	}

	public void deleteDetail(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Detail p = (Detail) session.load(Detail.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
