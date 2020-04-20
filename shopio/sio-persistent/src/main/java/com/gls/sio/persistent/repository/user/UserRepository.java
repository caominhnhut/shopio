package com.gls.sio.persistent.repository.user;

import java.util.List;

import com.gls.sio.persistent.entity.Authority;
import com.gls.sio.persistent.entity.UserEntity;
import com.gls.sio.persistent.repository.common.GenericDao;

public interface UserRepository extends GenericDao<UserEntity>
{
	List<Authority> getAllAuthorities();

	UserEntity findByEmail(String email);
}
