package com.gls.sio.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gls.sio.feed.model.Feed;
import com.gls.sio.feed.service.FeedService;
import com.gls.sio.persistent.entity.UserEntity;

@Controller
public class FeedController
{
	@Autowired
	private FeedService feedService;

	@RequestMapping(value = "feed", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Feed> create(@RequestBody @Valid Feed feed)
	{
		return new ResponseEntity<>(feedService.create(feed), HttpStatus.CREATED);
	}

	@RequestMapping(value = "no-auth/feed/latest", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Feed>> getLatestWithOutAuth(@RequestParam("limit") int limit, @RequestParam("offset") int offset)
	{
		List<Feed> feeds = feedService.getLatest(null, limit, offset);
		if (feeds.isEmpty())
		{
			return new ResponseEntity<>(feeds, HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(feeds, HttpStatus.OK);
	}

	@RequestMapping(value = "feed/latest", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Feed>> getLatest(@RequestParam("limit") int limit, @RequestParam("offset") int offset)
	{
		UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Feed> feeds = feedService.getLatest(userEntity.getId(), limit, offset);

		if (feeds.isEmpty())
		{
			return new ResponseEntity<>(feeds, HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(feeds, HttpStatus.OK);
	}
}
