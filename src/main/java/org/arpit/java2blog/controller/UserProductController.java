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
	UserProductService userUserProductService;
	
	@RequestMapping(value = "/getAllUserProducts", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<UserProduct> getUserProducts() {
		
		List<UserProduct> listOfUserProducts = userUserProductService.getAllUserProducts();
		return listOfUserProducts;
	}

	@RequestMapping(value = "/getUserProduct/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public UserProduct getUserProductById(@PathVariable int id) {
		return userUserProductService.getUserProduct(id);
	}

	@RequestMapping(value = "/addUserProduct", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addUserProduct(@RequestBody UserProduct userUserProduct) {	
		userUserProductService.addUserProduct(userUserProduct);
		
	}

	@RequestMapping(value = "/updateUserProduct", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateUserProduct(@RequestBody UserProduct userUserProduct) {
		userUserProductService.updateUserProduct(userUserProduct);
	}

	@RequestMapping(value = "/deleteUserProduct/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUserProduct(@PathVariable("id") int id) {
		userUserProductService.deleteUserProduct(id);		
	}	
}
