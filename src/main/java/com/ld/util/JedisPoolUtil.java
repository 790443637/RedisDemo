package com.ld.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

//双端检锁,保证线程不会被篡改
public class JedisPoolUtil {
	// 获取的池的实例
	private static volatile JedisPool jedisPool = null;

	// 私有化自身构造器
	private JedisPoolUtil() {
	}

	// 对外提供一个方法,返回这个池子的实例
	public static JedisPool getInstance() {
		// 判断没new才能进入
		if (jedisPool == null) synchronized (JedisPoolUtil.class) {// 加同步块,锁定一个对象
			if (jedisPool == null) {// 再次判断没new才能进入
				// JedisPoolConfig的配置
				JedisPoolConfig poolConfig = new JedisPoolConfig();
				//poolConfig.setMaxActive(1000);
				poolConfig.setMaxIdle(32);
				//poolConfig.setMaxWait(100 * 1000);
				poolConfig.setTestOnBorrow(true);
				jedisPool = new JedisPool(poolConfig, "192.168.1.109", 6379);
			}
		}
		return jedisPool;
	}

	// 关闭哪个池子的哪个实例
	public static void release(JedisPool jedisPool, Jedis jedis) {
		if (null != jedis) {
			jedisPool.returnResourceObject(jedis);
		}
	}
}
