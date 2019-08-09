package com.fjf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fjf.dao.UserDao;
import com.fjf.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UserDao userDao;
    @Test
    public void testRedis() throws JsonProcessingException {
        String userList = redisTemplate.boundValueOps("user.findAll").get();
        if(userList==null){
            List<User> users = userDao.queryUserList();
            ObjectMapper objectMapper = new ObjectMapper();
            userList = objectMapper.writeValueAsString(users);
            redisTemplate.boundValueOps("user.findAll").set(userList);
            System.out.println("==========从数据库获取数据===========");
        }else{
            System.out.println("============从Redis中获取数据==========");
        }
        System.out.println(userList);
    }
}
