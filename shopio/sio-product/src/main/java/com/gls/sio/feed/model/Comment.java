package com.gls.sio.feed.model;

public class Comment
{
	private String content;
	private User owner;

	public Comment(String content, User owner)
	{
		this.content = content;
		this.owner = owner;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public User getOwner()
	{
		return owner;
	}

	public void setOwner(User owner)
	{
		this.owner = owner;
	}
}
