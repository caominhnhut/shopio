package com.gls.sio.persistent.repository.feed.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.gls.sio.persistent.entity.FeedEntity;
import com.gls.sio.persistent.entity.FeedEntity_;
import com.gls.sio.persistent.entity.UserEntity_;
import com.gls.sio.persistent.repository.common.AbstractGenericDao;
import com.gls.sio.persistent.repository.feed.FeedRepository;

@Repository
public class FeedRepositoryImpl extends AbstractGenericDao<FeedEntity> implements FeedRepository
{
	@PostConstruct
	public void init()
	{
		super.setClazz(FeedEntity.class);
	}

	@Override
	public List<FeedEntity> getLatest(Long userId, int limit, int offset)
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FeedEntity> cq = cb.createQuery(FeedEntity.class);
		Root<FeedEntity> feed = cq.from(FeedEntity.class);
		cq.select(feed);

		if (userId != null)
		{
			cq.where(cb.equal(feed.get(FeedEntity_.owner).get(UserEntity_.id), userId));
		}

		cq.orderBy(cb.desc(feed.get(FeedEntity_.timestampCreated)));

		Query query = em.createQuery(cq);
		query.setFirstResult((offset-1)*limit);
		query.setMaxResults(limit);

		return query.getResultList();
	}
}
