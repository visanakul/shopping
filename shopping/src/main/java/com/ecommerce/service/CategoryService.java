package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.Category;

public interface CategoryService {
	public boolean add(Category category);

	public List<Category> list();

	public Category getById(int id);

	public boolean update(Category category);

	public boolean delete(Category category);
}
