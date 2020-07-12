package com.gls.sio.persistent.repository.product;

import java.util.List;

import com.gls.sio.persistent.entity.ProductEntity;
import com.gls.sio.persistent.repository.common.GenericDao;

public interface ProductRepository extends GenericDao<ProductEntity>
{
    List<ProductEntity> getLatest(Long userId, int limit, int offset);
}
