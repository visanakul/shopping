package com.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	public CategoryDAOImpl() {
		System.out.println("CategoryDAOImpl");
	}

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public static List<Category> getCategories() {
		return categories;
	}

	public static void setCategories(List<Category> categories) {
		CategoryDAOImpl.categories = categories;
	}

	private static List<Category> categories;

	static {
		categories = new ArrayList<>();

		Category c1 = new Category();
		c1.setId(1);
		c1.setName("Television");
		c1.setDecription("Television related description");
		c1.setImageUrl("CAT_1.png");
		categories.add(c1);

		Category c2 = new Category();
		c2.setId(2);
		c2.setName("Mobile");
		c2.setDecription("Mobile related description");
		c2.setImageUrl("CAT_2.png");
		categories.add(c2);

		Category c3 = new Category();
		c3.setId(3);
		c3.setName("Laptop");
		c3.setDecription("Laptop related description");
		c3.setImageUrl("CAT_3.png");
		categories.add(c3);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list() {
		// return categories;
		Query query = sessionFactory.getCurrentSession().createQuery("from Category where active=:ac");
		query.setParameter("ac", 'Y');
		return query.list();
	}

	@Override
	public Category getById(int id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Category category) {
		category.setActive('N');
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
