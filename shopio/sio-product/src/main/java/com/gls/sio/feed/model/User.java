package com.gls.sio.feed.model;

public class User
{
	private Long id;
	private String email;
	private String description;

	public User(Long id, String email, String description)
	{
		this.id = id;
		this.email = email;
		this.description = description;
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
