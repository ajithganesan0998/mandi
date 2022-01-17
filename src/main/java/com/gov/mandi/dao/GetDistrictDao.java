package com.gov.mandi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GetDistrictDao {
	
	@Autowired
	//@Qualifier("jbcTemplate1")
	JdbcTemplate jdbcTemplate;
	
	public List<String> getDistrictList(String state)
	{
		String districQuery = "select city_name from cities a,state_list b where a.state_id = b.state_id and b.state = ?";
		Object[] param = new Object[] {state};
		List<String> city = new ArrayList<String>();
		try
		{
			city = jdbcTemplate.queryForList(districQuery,String.class,param);			
		}
		catch(DataAccessException daoException)
		{
			daoException.printStackTrace();
		}
		return city;
		
	}
	
	public List<String> getDistrictListStatic(String state)
	{
		String districQuery = "select city_name from cities a,state_list b where a.state_id = b.state_id and b.state = ?";
		Object[] param = new Object[] {state};
		List<String> city = new ArrayList<String>();
		try
		{
			city = jdbcTemplate.queryForList(districQuery,String.class,param);			
		}
		catch(DataAccessException daoException)
		{
			daoException.printStackTrace();
		}
		return city;
		
	}

}
