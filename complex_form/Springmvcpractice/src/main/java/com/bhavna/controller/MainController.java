package com.bhavna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

	@RequestMapping("/home")
	
	public String home(Model model) {
		System.out.println("This is home page");
		
		return "contact";
	}
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query) {//class RedirectView extends AbstractUrlBasedView implements SmartView
	
		
	String url="https://www.google.com/search?q=" + query;
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(url);
		return redirectView;
	}
	
	
}

