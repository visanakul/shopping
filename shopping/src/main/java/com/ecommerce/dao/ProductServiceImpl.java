package com.ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	public ProductServiceImpl() {
		System.out.println("ProductServiceImpl");
	}

	@Autowired
	private ProductDAO productDAO;

	@Override
	public boolean add(Product product) {
		return productDAO.add(product);
	}

	@Override
	public boolean update(Product product) {
		return productDAO.update(product);
	}

	@Override
	public boolean delete(Product product) {
		return productDAO.delete(product);
	}

	@Override
	public Product get(int productId) {
		return productDAO.get(productId);
	}

	@Override
	public List<Product> list() {
		return productDAO.list();
	}

	@Override
	public List<Product> getActiveProducts() {
		return productDAO.getActiveProducts();
	}

	@Override
	public List<Product> getActiveProductsByCategory(int categoryId) {
		return productDAO.getActiveProductsByCategory(categoryId);
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return productDAO.getActiveProducts();
	}

}
