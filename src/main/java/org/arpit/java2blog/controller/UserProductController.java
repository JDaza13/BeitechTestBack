package org.arpit.java2blog.controller;

import java.util.List;
import org.arpit.java2blog.model.UserProduct;
import org.arpit.java2blog.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProductController {
	
	@Autowired
	UserProductService userProductService;
	
	@RequestMapping(value = "/getAllUserProducts", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<UserProduct> getUserProducts() {
		
		List<UserProduct> listOfUserProducts = userProductService.getAllUserProducts();
		return listOfUserProducts;
	}

	@RequestMapping(value = "/getUserProduct/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public UserProduct getUserProductById(@PathVariable int id) {
		return userProductService.getUserProduct(id);
	}

	@RequestMapping(value = "/addUserProduct", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addUserProduct(@RequestBody UserProduct userProduct) {	
		userProductService.addUserProduct(userProduct);
		
	}

	@RequestMapping(value = "/updateUserProduct", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateUserProduct(@RequestBody UserProduct userProduct) {
		userProductService.updateUserProduct(userProduct);
	}

	@RequestMapping(value = "/deleteUserProduct/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUserProduct(@PathVariable("id") int id) {
		userProductService.deleteUserProduct(id);		
	}	
}
