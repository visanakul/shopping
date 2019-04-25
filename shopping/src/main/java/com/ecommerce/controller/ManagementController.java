package com.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.dao.ProductService;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.service.CategoryService;
import com.ecommerce.util.FileUploadUtility;
import com.ecommerce.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	public ManagementController() {
		System.out.println("ManagementController");
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product product = new Product();
		product.setSupplierId(1);
		product.setActive('Y');
		mv.addObject("product", product);
		logger.info("New Product : " + product);
		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product added successfully...");
			}
		}
		return mv;
	}

	@RequestMapping("/products")
	public String handleProductSubmission(@Valid @ModelAttribute Product product, BindingResult results, Model model,
			HttpServletRequest request) {

		new ProductValidator().validate(product, results);
		
		if (results.hasErrors()) {
			System.out.println("Error found ");
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation errors");
			return "page";
		}
		logger.info("Product with data : " + product.toString());
		logger.info("File Name : " + product.getFile());
		if (!product.getFile().getOriginalFilename().equals("")) {
			System.out.println("Fileupload ");
			FileUploadUtility.upload(request, product.getFile(), product.getCode());
		}

		productService.add(product);
		return "redirect:/manage/products?operation=product";
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryService.list();
	}
}
