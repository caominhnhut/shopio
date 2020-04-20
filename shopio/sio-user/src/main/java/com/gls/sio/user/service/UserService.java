package com.gls.sio.user.service;

import java.util.List;

import com.gls.sio.user.dto.RegisteredUser;
import com.gls.sio.user.model.User;

public interface UserService
{
	List<User> findAll();
	RegisteredUser create(RegisteredUser registeredUser);
}
