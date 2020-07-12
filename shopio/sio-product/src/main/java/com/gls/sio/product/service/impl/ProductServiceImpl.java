package com.gls.sio.product.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gls.sio.persistent.repository.product.ProductRepository;
import com.gls.sio.product.model.Product;
import com.gls.sio.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository feedRepository;

	@Override
	public Product save(Product product) {
//		UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		FeedEntity feedEntity = new FeedEntity();
//		feedEntity.setDescription(feed.getDescription());
//		feedEntity.setOwner(userEntity);
//		feedEntity.setNumOfLike(feed.getNumOfLike());
//		feedEntity.setNumOfSharing(feed.getNumOfSharing());
//
//		try
//		{
//			FeedEntity createdFeed = feedRepository.create(feedEntity);
//			feed.setId(createdFeed.getId());
//			User user = new User(userEntity.getId(), userEntity.getEmail(), userEntity.getDescription());
//			feed.setOwner(user);
//		}
//		catch (Exception e)
//		{
//			logger.error("Can not create a feed");
//			throw new HKException(e.getMessage());
//		}
//
//		return feed;

		return null;
	}
}
