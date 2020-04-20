package com.gls.sio.feed.service;

import java.util.List;

import com.gls.sio.feed.model.Feed;

public interface FeedService
{
	Feed create(Feed feed);

	List<Feed> getLatest(Long userId, int limit, int offset);
}
