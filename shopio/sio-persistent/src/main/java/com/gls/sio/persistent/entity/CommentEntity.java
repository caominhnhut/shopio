package com.gls.sio.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "comment")
@SequenceGenerator(name = "comment_seq", initialValue = 1)
public class CommentEntity extends BaseTimestamp
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
	private Long id;

	@Column(name = "description")
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String description;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private UserEntity owner;

	@ManyToOne
	@JoinColumn(name = "feed_id")
	private FeedEntity feed;

	@ManyToOne
	@JoinColumn(name = "article_id")
	private ArticleEntity article;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public UserEntity getOwner()
	{
		return owner;
	}

	public void setOwner(UserEntity owner)
	{
		this.owner = owner;
	}

	public FeedEntity getFeed()
	{
		return feed;
	}

	public void setFeed(FeedEntity feed)
	{
		this.feed = feed;
	}

	public ArticleEntity getArticle()
	{
		return article;
	}

	public void setArticle(ArticleEntity article)
	{
		this.article = article;
	}
}
