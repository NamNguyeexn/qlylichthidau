package com.music.service;

import com.music.model.ResponseObject;
import com.music.model.User;

public interface IUserService {
	
	ResponseObject<User> login(User user);

}
