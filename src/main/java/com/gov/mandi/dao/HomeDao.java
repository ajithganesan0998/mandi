package com.gov.mandi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDao {
	@Autowired
	//@Qualifier("jdbcTemplate1")
	JdbcTemplate jdbcTemplate;
	
	public boolean validateLogin(Map<String,String> inputParam)
	{
		String loginQuery = "select count(*) from userdetails where user_alias = ? and User_Password = ?";
		boolean loginStatus = false;
		try
		{
		Object[] param = new Object[] {inputParam.get("username"),inputParam.get("password")};
		int count = jdbcTemplate.queryForObject(loginQuery, Integer.class, param);
		if(count >0)
			loginStatus = true;
			
		}
		catch(DataAccessException daoException)
		{
			daoException.printStackTrace();
		}
		return loginStatus;

	}
	
	
	public List<String> getcityState()
	{
		String loginQuery = "select  distinct  state  from state_list order by state asc";
				
		List<String> cityState = new ArrayList<String>();
		try
		{
		cityState = jdbcTemplate.queryForList(loginQuery,String.class);
			
		}
		catch(DataAccessException daoException)
		{
			daoException.printStackTrace();
		}
		return cityState;

	}

}
