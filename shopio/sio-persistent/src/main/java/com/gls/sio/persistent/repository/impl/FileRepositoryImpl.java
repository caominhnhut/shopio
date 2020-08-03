package com.gls.sio.persistent.repository.impl;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.gls.sio.persistent.entity.FileEntity;
import com.gls.sio.persistent.entity.FileEntity_;
import com.gls.sio.persistent.entity.ProductEntity_;
import com.gls.sio.persistent.repository.FileRepository;
import com.gls.sio.persistent.repository.common.AbstractGenericDao;

@Repository
public class FileRepositoryImpl extends AbstractGenericDao<FileEntity> implements FileRepository {
	
	@PostConstruct
	public void init() {
		super.setClazz(FileEntity.class);
	}

	@Override
	public FileEntity findByProductId(Long productId) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FileEntity> cq = cb.createQuery(FileEntity.class);
		Root<FileEntity> root = cq.from(FileEntity.class);
		cq.select(root);
		cq.where(cb.equal(root.get(FileEntity_.product).get(ProductEntity_.id), productId));
		TypedQuery<FileEntity> query = em.createQuery(cq);

		return query.getResultList().stream().findFirst().orElse(null);
	}
}
