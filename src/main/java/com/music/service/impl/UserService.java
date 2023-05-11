package com.music.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.model.ResponseObject;
import com.music.model.User;
import com.music.repository.UserRepo;
import com.music.service.IUserService;

import jakarta.xml.bind.DatatypeConverter;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserRepo userRepo;

	public String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(password.getBytes());
	    byte[] digest = md.digest();
	    String myHash = DatatypeConverter
	        .printHexBinary(digest);
	    return myHash;
	  }
	@Override
	public ResponseObject<User> login(User user) {
		try {
//			user.setPassword(user.getPassword());
		    Optional<User> _user = Optional.ofNullable(
		        userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword()));
		    if (!_user.isPresent()) {
		    	return new ResponseObject<User>("Tài khoản hoặc mật khẩu không chính xác!", null);
		    }
		    return new ResponseObject<User>("Đăng nhập thành công!", _user.get());
		} catch (Exception e) {
		    throw e;
		  }
	}
		
}
