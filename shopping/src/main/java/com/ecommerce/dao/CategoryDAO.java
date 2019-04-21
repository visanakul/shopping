package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Category;

public interface CategoryDAO {
	public boolean add(Category category);
	public List<Category> list();
	public Category getById(int id);
	public boolean update(Category category);
	public boolean delete(Category category);
}
