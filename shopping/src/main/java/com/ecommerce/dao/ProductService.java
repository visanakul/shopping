package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Product;

public interface ProductService {
	public boolean add(Product product);

	public boolean update(Product product);

	public boolean delete(Product product);

	public Product get(int productId);

	public List<Product> list();

	public List<Product> getActiveProducts();

	public List<Product> getActiveProductsByCategory(int categoryId);

	public List<Product> getLatestActiveProducts(int count);
}
