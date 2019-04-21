package com.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.dao.ProductService;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.service.CategoryService;

@Controller
public class PageController {

	private static Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	public PageController() {
		System.out.println("Controller ");
	}

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView home(ModelAndView mv) {
		System.out.println("Request for / or /home or /index");
		logger.info("Request for / or /home or /index : INFO");
		logger.debug("Request for / or /home or /index : DEBUG");

		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		mv.addObject("categories", categoryService.list());
		mv.setViewName("page");
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about(ModelAndView mv) {
		System.out.println("Request /about");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		mv.setViewName("page");
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact(ModelAndView mv) {
		System.out.println("Request /contact");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		mv.setViewName("page");
		return mv;
	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts(ModelAndView mv) {
		System.out.println("Request for /show/all/products");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		List<Category> catList = categoryService.list();
		System.out.println("Category List : " + catList);
		mv.addObject("categories", catList);
		mv.setViewName("page");
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		System.out.println("Request for /show/category/" + id + "/products");
		Category category = categoryService.getById(id);
		System.out.println("Category selected : " + category);
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", category.getName());
		mv.addObject("userClickCategoryProducts", true);
		mv.addObject("categories", categoryService.list());
		mv.addObject("category", category);
		mv.setViewName("page");
		return mv;
	}

	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingelProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");

		Product product = productService.get(id);
		product.setViews(product.getViews() + 1);
		productService.update(product);

		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);

		return mv;
	}
	// @RequestMapping(value = "/param_test")
	// public ModelAndView param_test(@RequestParam(required = false) String
	// msg) {
	// System.out.println("Request for /test");
	// if (msg == null) {
	// msg = "Default message";
	// }
	// ModelAndView mv = new ModelAndView();
	// mv.addObject("msg", msg);
	// mv.setViewName("home");
	// return mv;
	// }
	//
	// @RequestMapping(value = "/path_test/{msg}")
	// public ModelAndView path_test(@PathVariable String msg) {
	// System.out.println("Request for /test");
	// if (msg == null) {
	// msg = "Default message";
	// }
	// ModelAndView mv = new ModelAndView();
	// mv.addObject("msg", msg);
	// mv.setViewName("home");
	// return mv;
	// }
}
