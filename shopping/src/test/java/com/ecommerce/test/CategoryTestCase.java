package com.ecommerce.test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ecommerce.model.Category;
import com.ecommerce.service.CategoryService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CategoryServiceTestConfig.class})
public class CategoryTestCase  {


	private static CategoryService service;
	private Category category;


	public static CategoryService getService() {
		return service;
	}

	@Autowired
	public static void setService(CategoryService service) {
		CategoryTestCase.service = service;
	}


	@Test
	public void add() {
		category = new Category();
		category.setName("Television");
		category.setDecription("Decription of Television");
		category.setImageUrl("CAT_1.png");
		category.setActive('Y');
		assertEquals("Successfully added a category inside a table", true, service.add(category));
	}
}
