package com.gov.mandi.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class testDB2 {

	@Autowired
	JdbcTemplate jbcTemplatenew;
	
	@Autowired
	JdbcTemplate jbcTemplate;

	public  void test() {
		// TODO Auto-generated method stub
		try {
			
			/*
			 * jbcTemplatenew.
			 * update("INSERT INTO trn_person (person_id, first_name, Last_name, age) " +
			 * "VALUES (?, ?, ?, ?)");
			 */
				
			ArrayList test = (ArrayList) jbcTemplate.queryForList("SELECT * FROM city");
			System.out.println("test::::::"+test);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String []args)
	{
		
		testDB2 obj = new testDB2();
		obj.test();
		
	}

}
