package com.ld.mapper;

import com.ld.domain.User;

import java.util.List;


public interface UserMapper {
	
	void add(User u);
	
	void update(User u);
	
	User get(long id);

	User login(String name);

	void delete(long id);
	
	List<User> list();
}
