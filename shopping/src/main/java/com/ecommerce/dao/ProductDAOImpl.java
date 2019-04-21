package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	public ProductDAOImpl() {
		System.out.println("ProductDAOImpl");
	}

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive('N');
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Product get(int productId) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getActiveProducts() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Product where active=:act");
		query.setParameter("act", new Character('Y'));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getActiveProductsByCategory(int categoryId) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Product where active=:act and categoryId=:cid");
		query.setParameter("act", 'Y');
		query.setParameter("cid", categoryId);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getLatestActiveProducts(int count) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Product where active=:act order by id");
		query.setParameter("act", 'Y');
		query.setFirstResult(0);
		query.setMaxResults(count);
		return query.list();
	}

}
