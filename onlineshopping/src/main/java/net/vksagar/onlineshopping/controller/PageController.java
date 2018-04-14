package net.vksagar.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.vksagar.shoppingbackend.dao.CategoryDAO;
import net.vksagar.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value= {"/","/home", "/index"})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", "Home");
		//passig list of categories
		modelAndView.addObject("categories",categoryDAO.list());
		modelAndView.addObject("userClickHome", true);
		return modelAndView;
	}
	
	@RequestMapping(value= {"/about"})
	public ModelAndView about() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", "About Us");
		modelAndView.addObject("userClickAbout", true);
		return modelAndView;
	}
	
	@RequestMapping(value= {"/contact"})
	public ModelAndView contact() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", "Contact Us");
		modelAndView.addObject("userClickContact", true);
		return modelAndView;
	}
	/*
	 * Method to load all the products and based on category
	 */
	@RequestMapping(value= {"/show/all/products"})
	public ModelAndView showAllProducts() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", "All Products");
		//passig list of categories
		modelAndView.addObject("categories",categoryDAO.list());
		modelAndView.addObject("userClickAllProducts", true);
		return modelAndView;
	}
	
	@RequestMapping(value= {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("page");
		
		//categoryDAO to fetch single category
		Category category = null;
		category = categoryDAO.get(id);
		modelAndView.addObject("title", category.getName());
		//passigg list of categories
		modelAndView.addObject("categories",categoryDAO.list());
		
		//passing single category object
		modelAndView.addObject("category", category);
		modelAndView.addObject("userClickCategoryProducts", true);
		return modelAndView;
	}
	
	/*@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false) String greeting) {
		ModelAndView modelAndView = new ModelAndView("page");
		
		if(greeting == null) 
			greeting = "No words";
		modelAndView.addObject("greeting", greeting);
		return modelAndView;
	}*/
	
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greeting) {
		ModelAndView modelAndView = new ModelAndView("page");
		
		if(greeting == null) 
			greeting = "No words";
		modelAndView.addObject("greeting", greeting);
		return modelAndView;
	}
	
}
