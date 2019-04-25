package com.ecommerce.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ecommerce.model.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product=(Product) target;
		
		System.out.println("Validation product : "+product);
		System.out.println("Validation File : "+product.getFile());
		System.out.println("Validation Original File : "+product.getFile().getOriginalFilename());

		if(product.getFile()==null ||product.getFile().getOriginalFilename().equals("")){
			errors.rejectValue("file", null, "Please select image file to upload!");
			System.out.println("Please select image file to upload!");
			return;
		}
		
		String mimeType=product.getFile().getContentType();
		if(!(mimeType.equals("images/jpg")||mimeType.equals("images/png")||mimeType.equals("images/gif"))){
			 errors.rejectValue("file", null,"Please select jpg/png/gif image!");
			 return;
		}
	}

}
