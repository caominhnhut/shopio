package com.gls.sio.persistent.repository.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.gls.sio.persistent.entity.CategoryEntity;
import com.gls.sio.persistent.repository.CategoryRepository;
import com.gls.sio.persistent.repository.common.AbstractGenericDao;

@Repository
public class CategoryRepositoryImpl extends AbstractGenericDao<CategoryEntity> implements CategoryRepository{
	
	@PostConstruct
    public void init()
    {
        super.setClazz(CategoryEntity.class);
    }
}
