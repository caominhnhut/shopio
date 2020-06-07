package com.gls.sio.persistent.repository.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.gls.sio.persistent.entity.FeedEntity_;
import com.gls.sio.persistent.entity.ProductEntity;
import com.gls.sio.persistent.entity.UserEntity_;
import com.gls.sio.persistent.repository.ProductRepository;
import com.gls.sio.persistent.repository.common.AbstractGenericDao;

@Repository
public class ProductRepositoryImpl extends AbstractGenericDao<ProductEntity> implements ProductRepository
{
	@PostConstruct
	public void init()
	{
		super.setClazz(ProductEntity.class);
	}

	@Override
	public List<ProductEntity> getLatest(Long userId, int limit, int offset)
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ProductEntity> cq = cb.createQuery(ProductEntity.class);
		Root<ProductEntity> feed = cq.from(ProductEntity.class);
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
