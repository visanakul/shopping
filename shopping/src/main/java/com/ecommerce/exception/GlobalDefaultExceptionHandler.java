package com.ecommerce.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class GlobalDefaultExceptionHandler {

	public GlobalDefaultExceptionHandler() {
		System.out.println("GlobalDefaultExceptionHandler");
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		System.out.println("Error handler");
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Page Not Constructed");
		mv.addObject("errorDescription", "The page you requested is not available now!!!");
		mv.addObject("title", "404 Error Page");
		return mv;
	}

	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(value = { Exception.class, RuntimeException.class })
	public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
		System.out.println("Error handler");
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Contact your administrator!!!");
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		e.printStackTrace(pw);
		mv.addObject("errorDescription", sw.toString());
		mv.addObject("title", "Error in Application");
		return mv;
	}
}
