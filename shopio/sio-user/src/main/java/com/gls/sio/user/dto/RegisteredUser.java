package com.gls.sio.user.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.gls.sio.user.annotation.ValidEmail;
import com.gls.sio.user.annotation.ValidPassword;
import com.gls.sio.user.annotation.ValidPasswordMatches;

@ValidPasswordMatches
public class RegisteredUser
{
	private Long id;

	@ValidEmail
	@NotEmpty(message = "Please enter the email")
	private String email;

	@NotEmpty(message = "Please enter the password")
	@Size(min = 8, max = 20, message = "The length of password should have from 8 to 20 letters")
	@ValidPassword
	private String password;

	@NotEmpty(message = "Please enter the password for conformation")
	private String confirmedPassword;

	private List<String> authorities = new ArrayList<>();

	public RegisteredUser()
	{

	}

	public RegisteredUser(Long id, String email, String password)
	{
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getConfirmedPassword()
	{
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword)
	{
		this.confirmedPassword = confirmedPassword;
	}

	public List<String> getAuthorities()
	{
		return authorities;
	}
}
