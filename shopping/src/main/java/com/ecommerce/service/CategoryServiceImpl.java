package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.CategoryDAO;
import com.ecommerce.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	public CategoryServiceImpl() {
		System.out.println("CategoryDAOServiceImpl");
	}

	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public boolean add(Category category) {
		return categoryDAO.add(category);
	}

	@Override
	public List<Category> list() {
		return categoryDAO.list();
	}

	@Override
	public Category getById(int id) {
		return categoryDAO.getById(id);
	}

	@Override
	public boolean update(Category category) {
		return categoryDAO.update(category);
	}

	@Override
	public boolean delete(Category category) {
		return categoryDAO.delete(category);
	}

}
