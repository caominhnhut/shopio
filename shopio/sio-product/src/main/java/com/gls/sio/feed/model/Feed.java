package com.gls.sio.feed.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class Feed
{
	private Long id;

	@NotNull(message = "Description should not be null")
	private String description;

	private Long numOfLike = 0L;
	private Long numOfSharing = 0L;
	private User owner;
	private List<Comment> comments = new ArrayList<>();

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Long getNumOfLike()
	{
		return numOfLike;
	}

	public void setNumOfLike(Long numOfLike)
	{
		this.numOfLike = numOfLike;
	}

	public Long getNumOfSharing()
	{
		return numOfSharing;
	}

	public void setNumOfSharing(Long numOfSharing)
	{
		this.numOfSharing = numOfSharing;
	}

	public User getOwner()
	{
		return owner;
	}

	public void setOwner(User owner)
	{
		this.owner = owner;
	}

	public List<Comment> getComments()
	{
		return comments;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
}
