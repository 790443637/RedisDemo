package com.ld.service;

import com.ld.domain.User;
import com.ld.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private JedisPool jedisPool;

	@Autowired
	private UserMapper userMapper;


	public void add(User u) {
		userMapper.add(u);
	}

	public void update(User u) {
		userMapper.update(u);
	}

	public User get(long id) {
		return userMapper.get(id);
	}

	public User login(String name) {
		return userMapper.login(name);
	}

	public void delete(long id) {
		userMapper.delete(id);
	}

	public List<User> list() {
		return userMapper.list();
	}

	public void redisSet(String name,String pass) {
		Jedis j = jedisPool.getResource();
		j.set(name,pass);
	}

	public String redisGet(String name) {
		Jedis j = jedisPool.getResource();
		return j.get(name);
	}
}
