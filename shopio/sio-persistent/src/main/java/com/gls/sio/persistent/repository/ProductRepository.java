package com.gls.sio.persistent.repository;

import java.util.List;

import com.gls.sio.persistent.entity.ProductEntity;
import com.gls.sio.persistent.model.ProductRequest;
import com.gls.sio.persistent.repository.common.GenericDao;

public interface ProductRepository extends GenericDao<ProductEntity>
{
    List<ProductEntity> getProducts(ProductRequest productRequest);
}
