package org.arpit.java2blog.service;

import java.util.List;
import org.arpit.java2blog.dao.UserProductDAO;
import org.arpit.java2blog.model.UserProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userProductService")
public class UserProductService {

	@Autowired
	UserProductDAO userProductDao;
	
	@Transactional
	public List<UserProduct> getAllUserProducts() {
		return userProductDao.getAllUserProducts();
	}

	@Transactional
	public UserProduct getUserProduct(int id) {
		return userProductDao.getUserProduct(id);
	}

	@Transactional
	public void addUserProduct(UserProduct userProduct) {
		userProductDao.addUserProduct(userProduct);
	}

	@Transactional
	public void updateUserProduct(UserProduct userProduct) {
		userProductDao.updateUserProduct(userProduct);

	}

	@Transactional
	public void deleteUserProduct(int id) {
		userProductDao.deleteUserProduct(id);
	}
}
