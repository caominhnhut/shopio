package com.gls.sio.user.factory;

import java.util.function.Function;

import com.gls.sio.persistent.entity.Authority;
import com.gls.sio.persistent.entity.AuthorityName;
import com.gls.sio.persistent.entity.UserEntity;
import com.gls.sio.user.dto.RegisteredUser;
import com.gls.sio.user.model.User;

public class Mapper
{
	private static Function<RegisteredUser, UserEntity> registeredUserToUserEntity = registeredUser -> {
		UserEntity user = new UserEntity();
		user.setEmail(registeredUser.getEmail());
		user.setPassword(registeredUser.getPassword());
		registeredUser.getAuthorities().forEach(name -> {
			Authority authority = new Authority();
			authority.setName(AuthorityName.valueOf(name));
			user.getRoles().add(authority);
		});
		return user;
	};

	private static Function<UserEntity, RegisteredUser> userEntityToRegisteredUser = userEntity -> {
		RegisteredUser registeredUser = new RegisteredUser();
		registeredUser.setId(userEntity.getId());
		registeredUser.setEmail(userEntity.getEmail());
		return registeredUser;
	};

	private static Function<UserEntity, User> userEntityToUser = userEntity -> {
		return new com.gls.sio.user.model.User(userEntity.getId(), userEntity.getEmail());
	};

	public static UserEntity from(RegisteredUser userRequest)
	{
		return registeredUserToUserEntity.apply(userRequest);
	}

	public static RegisteredUser from(UserEntity user)
	{
		return userEntityToRegisteredUser.apply(user);
	}

	public static User convert(UserEntity user)
	{
		return userEntityToUser.apply(user);
	}
}
