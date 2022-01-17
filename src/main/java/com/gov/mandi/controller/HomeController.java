package com.gov.mandi.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.gov.mandi.service.HomeService;

@Controller
public class HomeController {
	@Autowired
	HomeService homeService;
	
	/*
	 * @Autowired MandiJWT mandiJWT;
	 */
	@Autowired
	testDB2 testDB2;
	
	
	@GetMapping("/home")
	public String mandiHome(Model model)
	{
		/* mandiJWT.generateToken(null, null); */
		
		model.addAttribute("test", "hi");
		return "mandiHome";
		
	}
	
	@PostMapping("/loginSubmit")
	public String loginSubmit(@RequestParam Map<String,String> inputMap,Model model,HttpServletRequest req, HttpServletResponse resp)
	{
		System.out.println(req.getParameter("username"));
		
		boolean loginValidation = homeService.loginValidate(inputMap);
		String view = "mandiHome";
		if(loginValidation)
		{
			RequestDispatcher dispatcher = req.getServletContext()
				      .getRequestDispatcher("/mandilandingPage");
				    try {
						dispatcher.forward(req, resp);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    return null;

		}
		else
		{
			model.addAttribute("loginFailed", true);
		}
		return view;
		
	}
	
	@PostMapping("/mandilandingPage")
	public String mandilandingPage(@RequestParam Map<String,String> inputMap,Model model,HttpServletRequest req, HttpServletResponse resp)
	{

		List<String> cityState = homeService.getcityState();
		model.addAttribute("cityState", cityState);
		return "mandilandingPage";
	
	}
	
	
	@GetMapping("/test")
	public String testJdbc(Model model)
	{
		/* mandiJWT.generateToken(null, null); */
		testDB2.test();
		model.addAttribute("test", "hi");
		return "mandiHome";
		
	}
	


}
