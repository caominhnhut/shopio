package com.gls.sio.persistent.repository.impl;

import static com.gls.sio.persistent.repository.common.DaoHelper.DEFAULT_LIMIT;
import static com.gls.sio.persistent.repository.common.DaoHelper.DEFAULT_OFFSET;
import static com.gls.sio.persistent.repository.common.DaoHelper.addPredicateWithLong;
import static com.gls.sio.persistent.repository.common.DaoHelper.addPredicateWithString;
import static com.gls.sio.persistent.repository.common.DaoHelper.encloseWithWildCard;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.gls.sio.persistent.entity.CategoryEntity_;
import com.gls.sio.persistent.entity.ProductEntity;
import com.gls.sio.persistent.entity.ProductEntity_;
import com.gls.sio.persistent.entity.UserEntity_;
import com.gls.sio.persistent.model.ProductRequest;
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
	public List<ProductEntity> getProducts(ProductRequest productRequest)
	{
		int limit = productRequest.getLimit() == 0 ? DEFAULT_LIMIT : productRequest.getLimit();
		int offset = productRequest.getOffset() == 0 ? DEFAULT_OFFSET : productRequest.getOffset();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ProductEntity> cq = cb.createQuery(ProductEntity.class);
		Root<ProductEntity> productEntityRoot = cq.from(ProductEntity.class);
		
		List<Predicate> predicates = getFilterPredicate(productRequest, productEntityRoot, cb);
		cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
		cq.orderBy(cb.desc(productEntityRoot.get(ProductEntity_.timestampCreated)));
		
		TypedQuery<ProductEntity> query = em.createQuery(cq);
		query.setFirstResult((offset-1)*limit);
		query.setMaxResults(limit);

		return query.getResultList();
	}
	
	private List<Predicate> getFilterPredicate(ProductRequest productRequest, Root<ProductEntity> productEntityRoot, CriteriaBuilder cb)
	{
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		addPredicateWithLong(productRequest.getId(), predicates, productId -> cb.equal(productEntityRoot.get(ProductEntity_.id), productId));
		
		addPredicateWithString(productRequest.getCode(), predicates, code -> cb.like(productEntityRoot.get(ProductEntity_.code), encloseWithWildCard(code.toUpperCase())));
		
		addPredicateWithString(productRequest.getName(), predicates, name -> cb.like(productEntityRoot.get(ProductEntity_.name), encloseWithWildCard(name)));
		
		addPredicateWithLong(productRequest.getCostPriceFrom(), predicates, costPrice -> cb.greaterThanOrEqualTo(productEntityRoot.get(ProductEntity_.costPrice), costPrice));
		
		addPredicateWithLong(productRequest.getCostPriceTo(), predicates, costPrice -> cb.lessThanOrEqualTo(productEntityRoot.get(ProductEntity_.costPrice), costPrice));
		
		addPredicateWithLong(productRequest.getSellingPriceFrom(), predicates, sellingPrice -> cb.greaterThanOrEqualTo(productEntityRoot.get(ProductEntity_.sellingPrice), sellingPrice));
		
		addPredicateWithLong(productRequest.getSellingPriceTo(), predicates, sellingPrice -> cb.lessThanOrEqualTo(productEntityRoot.get(ProductEntity_.sellingPrice), sellingPrice));
		
		//TODO: search by date
		
		addPredicateWithLong(productRequest.getCategoryId(), predicates, categoryId -> cb.equal(productEntityRoot.get(ProductEntity_.category).get(CategoryEntity_.id), categoryId));
		
		addPredicateWithLong(productRequest.getOwnerId(), predicates, ownerId -> cb.equal(productEntityRoot.get(ProductEntity_.owner).get(UserEntity_.id), ownerId));
		
		return predicates;
	}
}
