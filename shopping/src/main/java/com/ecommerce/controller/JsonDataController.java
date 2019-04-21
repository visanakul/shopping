package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.dao.ProductService;
import com.ecommerce.model.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductService productService;

	public JsonDataController() {
		System.out.println("JsonDataController");
	}

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		List<Product> productList = productService.list();
		System.out.println("All Products : " + productList);
		return productList;
	}

	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getCategoryProducts(@PathVariable int id) {
		return productService.getActiveProductsByCategory(id);
	}
}
