package com.gov.mandi.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gov.mandi.UserPOJO;

@Repository
public class UserRegisDao {
	
	@Autowired
	//@Qualifier("jbcTemplate")
	JdbcTemplate jdbcTemplate;
	
	public boolean insertUser(UserPOJO userPOJO)
	{
		String updateQuery = "INSERT INTO state_list (Name, Email_address,Date_of_birth,PAN,City,State,User_Id,password,User_Alias) "
				+ "values(?,?,?,?,?,?,?,?,?,)";
		boolean loginStatus = false;
		try
		{
		Object[] param = new Object[] {userPOJO.getName(),userPOJO.getUserName(),userPOJO.getPassword(),
										userPOJO.getEmail(),userPOJO.getPAN(),userPOJO.getSfAuth(),userPOJO.getDob(),
										userPOJO.getState(),userPOJO.getCity()};
		int count = jdbcTemplate.update(updateQuery, param, Integer.class);
		if(count >0)
			loginStatus = true;
			
		}
		catch(DataAccessException daoException)
		{
			daoException.printStackTrace();
		}
		return loginStatus;

	}

}
