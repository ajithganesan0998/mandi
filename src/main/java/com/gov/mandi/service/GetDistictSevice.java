package com.gov.mandi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gov.mandi.dao.GetDistrictDao;

@Service
public class GetDistictSevice {
	@Autowired
	GetDistrictDao getDistrictDao;
	public List<String> getdist(String stateName)
	{
		List<String> cityList = new ArrayList<String>();

		if(stateName != null  && !"".equals(stateName))
		{
			cityList = getDistrictDao.getDistrictList(stateName);
		}
		
		return cityList;
		
	}

}
