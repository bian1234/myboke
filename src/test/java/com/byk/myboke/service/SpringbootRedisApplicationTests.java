package com.byk.myboke.service;

import com.byk.myboke.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author: bianyakun
 * @Date: 2018/6/29 9:44
 * @Todo:目前的业务中还没用到redis，因此先放在test文件中进行测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired

    RedisDao redisDao;


    @Test
    public void testRedis(){
        redisDao.setKey("name","bian");
        redisDao.setKey("age","18");
        redisDao.setKey("professional","farmers");
        System.out.println(redisDao.getValue("name"));
        System.out.println(redisDao.getValue("age"));
        System.out.println(redisDao.getValue("professional"));
    }
}
