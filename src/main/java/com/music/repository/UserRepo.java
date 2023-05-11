package com.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	User findByUsernameAndPassword(String username, String password);
}
