package com.ld;

import com.ld.domain.User;
import com.ld.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringAndMyBatisTest {

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void test() throws Exception {
        Jedis j = jedisPool.getResource();
        Set<String> keys = j.keys("*");
        for(String s:keys){
            System.out.println(s);
        }
    }
}
