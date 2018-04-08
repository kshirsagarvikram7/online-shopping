package net.vksagar.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value= {"/","/home", "/index"})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("greeting", "Welcome to SPRING MVC");
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
