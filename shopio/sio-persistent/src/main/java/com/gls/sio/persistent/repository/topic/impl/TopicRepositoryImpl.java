package com.gls.sio.persistent.repository.topic.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.gls.sio.persistent.entity.TopicEntity;
import com.gls.sio.persistent.repository.common.AbstractGenericDao;
import com.gls.sio.persistent.repository.topic.TopicRepository;

@Repository
public class TopicRepositoryImpl extends AbstractGenericDao<TopicEntity> implements TopicRepository
{
	@PostConstruct
	public void init()
	{
		super.setClazz(TopicEntity.class);
	}
}
