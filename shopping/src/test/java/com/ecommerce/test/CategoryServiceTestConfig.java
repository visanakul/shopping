package com.ecommerce.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecommerce.dao.CategoryDAO;
import com.ecommerce.dao.CategoryDAOImpl;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.CategoryServiceImpl;

@Configuration
public class CategoryServiceTestConfig {
	@Bean
	public CategoryDAO categoryDAO() {
		return new CategoryDAOImpl();
	}

	@Bean
	public CategoryService categoryService() {
		return new CategoryServiceImpl();
	}
}
