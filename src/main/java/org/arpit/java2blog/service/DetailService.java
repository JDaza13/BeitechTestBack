package org.arpit.java2blog.service;

import java.util.List;
import org.arpit.java2blog.dao.DetailDAO;
import org.arpit.java2blog.model.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("detailService")
public class DetailService {

	@Autowired
	DetailDAO detailDao;
	
	@Transactional
	public List<Detail> getAllDetails() {
		return detailDao.getAllDetails();
	}

	@Transactional
	public Detail getDetail(int id) {
		return detailDao.getDetail(id);
	}

	@Transactional
	public void addDetail(Detail detail) {
		detailDao.addDetail(detail);
	}

	@Transactional
	public void updateDetail(Detail detail) {
		detailDao.updateDetail(detail);

	}

	@Transactional
	public void deleteDetail(int id) {
		detailDao.deleteDetail(id);
	}
}
