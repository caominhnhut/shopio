package com.gls.sio.feed.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.gls.sio.feed.exception.HKException;
import com.gls.sio.feed.model.Comment;
import com.gls.sio.feed.model.Feed;
import com.gls.sio.feed.model.User;
import com.gls.sio.feed.service.FeedService;
import com.gls.sio.persistent.entity.CommentEntity;
import com.gls.sio.persistent.entity.FeedEntity;
import com.gls.sio.persistent.entity.UserEntity;
import com.gls.sio.persistent.repository.feed.FeedRepository;

@Service
public class FeedServiceImpl implements FeedService
{
	private Logger logger = LoggerFactory.getLogger(FeedService.class);

	@Autowired
	private FeedRepository feedRepository;

	@Override
	public Feed create(Feed feed)
	{
		UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		FeedEntity feedEntity = new FeedEntity();
		feedEntity.setDescription(feed.getDescription());
		feedEntity.setOwner(userEntity);
		feedEntity.setNumOfLike(feed.getNumOfLike());
		feedEntity.setNumOfSharing(feed.getNumOfSharing());

		try
		{
			FeedEntity createdFeed = feedRepository.create(feedEntity);
			feed.setId(createdFeed.getId());
			User user = new User(userEntity.getId(), userEntity.getEmail(), userEntity.getDescription());
			feed.setOwner(user);
		}
		catch (Exception e)
		{
			logger.error("Can not create a feed");
			throw new HKException(e.getMessage());
		}

		return feed;
	}

	@Override
	public List<Feed> getLatest(Long userId, int limit, int offset)
	{
		List<FeedEntity> feedEntities = feedRepository.getLatest(userId, limit, offset);
		return feedEntities.stream().map(this::from).collect(Collectors.toList());
	}

	private Feed from(FeedEntity feedEntity)
	{
		Feed feed = new Feed();
		feed.setId(feedEntity.getId());
		feed.setDescription(feedEntity.getDescription());
		feed.setNumOfLike(feedEntity.getNumOfLike());
		feed.setNumOfSharing(feedEntity.getNumOfSharing());

		UserEntity userEntity = feedEntity.getOwner();
		User owner = new User(userEntity.getId(), userEntity.getEmail(), userEntity.getDescription());
		feed.setOwner(owner);

		List<Comment> comments = feedEntity.getComments().stream().map(this::from).collect(Collectors.toList());
		feed.getComments().addAll(comments);

		return feed;
	}

	private Comment from(CommentEntity commentEntity)
	{
		UserEntity userEntity = commentEntity.getOwner();
		User owner = new User(userEntity.getId(), userEntity.getEmail(), userEntity.getDescription());

		return new Comment(commentEntity.getDescription(), owner);
	}
}
