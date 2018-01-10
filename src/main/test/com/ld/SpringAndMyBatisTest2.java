package com.ld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringAndMyBatisTest2 {

    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void test() throws Exception {
        jedisCluster.set("老王","666");
        System.out.println( jedisCluster.get("老王"));
    }
}
