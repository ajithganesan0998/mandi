package com.gov.mandi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.gov.mandi.UserPOJO;
import com.gov.mandi.model.VegPrice;
import com.gov.mandi.service.GetDistictSevice;
import com.gov.mandi.service.HomeService;

@Controller
public class MandiController {
	@Autowired
	GetDistictSevice getDistictSevice;
	
	@Autowired
	HomeService homeService;
	
	@PostMapping("/getDitictDtls")
	public String getDitictDtls(Model model,@RequestParam Map<String,String> inputMap,HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("inputMap::"+inputMap);
		List<String> outputParams = getDistictSevice.getdist(inputMap.get("state"));
		if(true)
		{
		Gson gson = new Gson();
        String jsonString = null;
        jsonString = gson.toJson(outputParams);

		response.setContentType("text/plain;charset=UTF-8");
		try {
			response.getWriter().println(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return null;
	}
	
	
	@PostMapping("/mandiDashBoard")
	public String mandiDashBoard(@RequestParam Map<String,String> inputMap,Model model,HttpServletRequest req, HttpServletResponse resp)
	{

		List<VegPrice> vegPriceList = homeService.getVegetablePrice(inputMap);;
		model.addAttribute("vegPriceList", vegPriceList);
		return "mandiDashBoard";
	
	}
	
	@GetMapping("/newUser")
	public String newUserReg(Model model,@RequestParam Map<String,String> inputMap)
	{
		List<String> cityState = homeService.getcityState();
		model.addAttribute("cityState", cityState);
		return "newUserReg";
		
	}
	@PostMapping("/newUserCreate")
	public String newUserCreate(Model model,@RequestParam Map<String,String> inputMap ,@ModelAttribute UserPOJO userPOJO)
	{
		/*@RequestParam */	
		inputMap.entrySet()
		.stream()
		.forEach(s -> System.out.println(s.getKey()+":"+s.getValue()));
		return "newUserReg";
		
	}

}
