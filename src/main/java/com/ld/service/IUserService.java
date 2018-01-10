package com.ld.service;

import com.ld.domain.User;

import java.util.List;

public interface IUserService {

	void add(User u);
	
	void update(User u);
	
	User get(long id);

	User login(String name);
	
	void delete(long id);
	
	List<User> list();

	void redisSet(String name,String pass);

	String redisGet(String name);
}
