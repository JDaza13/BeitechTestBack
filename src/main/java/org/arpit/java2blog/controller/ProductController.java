package org.arpit.java2blog.controller;

import java.util.List;
import org.arpit.java2blog.model.Product;
import org.arpit.java2blog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Product> getProducts() {
		
		List<Product> listOfProducts = productService.getAllProducts();
		return listOfProducts;
	}

	@RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Product getProductById(@PathVariable int id) {
		return productService.getProduct(id);
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addProduct(@RequestBody Product product) {	
		productService.addProduct(product);
		
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
	}

	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteProduct(@PathVariable("id") int id) {
		productService.deleteProduct(id);		
	}	
}
