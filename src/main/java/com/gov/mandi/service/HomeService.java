package com.gov.mandi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.text.CaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.gov.mandi.dao.HomeDao;
import com.gov.mandi.model.VegPrice;
import com.gov.mandi.util.StringUtilities;

@Service
public class HomeService {
	@Autowired
	HomeDao homeDao;
	
	@Value(value = "${mandipApi}")
	private String mandipApi;
	
	public boolean loginValidate(Map<String,String> inputParam)
	{
		
		boolean loginStatus = homeDao.validateLogin(inputParam);
		return loginStatus;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<VegPrice> getVegetablePrice(Map<String,String> inMap)
	{
		//mandipApi = mandipApi 
		RestTemplate restTemplate = new RestTemplate();
		List<VegPrice> vegPriceList = new ArrayList<VegPrice>();
		/*
		 * ResponseEntity<String> response = restTemplate.getForEntity(mandipApi+
		 * "&filters[state]="+inMap.get("state")
		 * +""+"&filters[district]="+inMap.get("city"), String.class);
		 */
		ResponseEntity<String> response
		  = restTemplate.getForEntity(mandipApi+ "&offset=0&limit=10"+"&filters[state]="+StringUtilities.toUpperCamelCase(inMap.get("state")), String.class);
		//assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root;
		JsonNode name;
		Object count = new Object();;
		try {
			root = mapper.readTree(response.getBody());
			 name = root.path("total");
			 count = name.asInt();
			 
			 if(count != null)
			 {
				 int loopCount =  ((Integer)count)%10 ==0 ? ((Integer)count/10) : (((Integer)count/10)+1);
				 loopCount = loopCount > 3 ? 3 : loopCount;
				 int offset = 0,limit = 10;				 
				 for (int i=0;i< loopCount;i++)
				 {
					 mandipApi = mandipApi + "&offset="+offset+"&limit="+limit;
					response = restTemplate.getForEntity(mandipApi+ "&filters[state]="+StringUtilities.toUpperCamelCase(inMap.get("state")), String.class);
					String mapperObject = response.getBody();
					Map<String,Object> obj = new HashMap<String,Object>();
					obj = mapper.readValue(mapperObject, HashMap.class);
					 vegPriceList.addAll((List<VegPrice> )obj.get("records"));
					offset += 10;
					limit += 10;
				 }
			 }


		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vegPriceList;
		
	}
	
	public List<String> getcityState()
	{
		
		List<String> cityState = homeDao.getcityState();
		
		return cityState;
		
	}

}
