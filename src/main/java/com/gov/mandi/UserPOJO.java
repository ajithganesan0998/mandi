package com.gov.mandi;

import org.springframework.stereotype.Component;


public class UserPOJO {
	
	String Name       ;
	String UserName   ;
	String Password   ;
	String Email      ;
	String PAN        ;
	String SfAuth     ;
	String Dob        ;
	String State      ;
	String City       ;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	public String getSfAuth() {
		return SfAuth;
	}
	public void setSfAuth(String sfAuth) {
		SfAuth = sfAuth;
	}
	public String getDob() {
		return Dob;
	}
	public void setDob(String dob) {
		Dob = dob;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	

}
