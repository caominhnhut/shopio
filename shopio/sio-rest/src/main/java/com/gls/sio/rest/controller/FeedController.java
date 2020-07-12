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

import com.gls.sio.persistent.entity.UserEntity;
import com.gls.sio.product.model.Product;
import com.gls.sio.product.service.ProductService;

@Controller
public class FeedController
{
	@Autowired
	private ProductService feedService;

	@RequestMapping(value = "feed", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Product> create(@RequestBody @Valid Product feed)
	{
		return null;//new ResponseEntity<>(feedService.create(feed), HttpStatus.CREATED);
	}

	@RequestMapping(value = "no-auth/feed/latest", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Product>> getLatestWithOutAuth(@RequestParam("limit") int limit, @RequestParam("offset") int offset)
	{
//		List<Product> feeds = feedService.getLatest(null, limit, offset);
//		if (feeds.isEmpty())
//		{
//			return new ResponseEntity<>(feeds, HttpStatus.NO_CONTENT);
//		}

		return null;//new ResponseEntity<>(feeds, HttpStatus.OK);
	}

	@RequestMapping(value = "feed/latest", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Product>> getLatest(@RequestParam("limit") int limit, @RequestParam("offset") int offset)
	{
//		UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		List<Product> feeds = feedService.getLatest(userEntity.getId(), limit, offset);
//
//		if (feeds.isEmpty())
//		{
//			return new ResponseEntity<>(feeds, HttpStatus.NO_CONTENT);
//		}

		return null;//new ResponseEntity<>(feeds, HttpStatus.OK);
	}
}
