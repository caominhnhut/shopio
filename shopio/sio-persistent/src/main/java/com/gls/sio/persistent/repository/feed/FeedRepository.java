package com.gls.sio.persistent.repository.feed;

import java.util.List;

import com.gls.sio.persistent.entity.FeedEntity;
import com.gls.sio.persistent.entity.TopicEntity;
import com.gls.sio.persistent.repository.common.GenericDao;

public interface FeedRepository extends GenericDao<FeedEntity>
{
    List<FeedEntity> getLatest(Long userId, int limit, int offset);
}
