package com.example.demo_jpa;

import com.example.demo_jpa.domain.User;
import com.example.demo_jpa.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoJpaApplication.class)
public class RedisTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void Test(){
        String userListData = redisTemplate.boundValueOps("user.findAll").get();
        if(null==userListData){
            List<User> all = userRepository.findAll();
            ObjectMapper om = new ObjectMapper();
            try {
                userListData = om.writeValueAsString(all);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            redisTemplate.boundValueOps("user.findAll").set(userListData);
            System.out.println("===============从数据库获得数据===============");
        }else{
            System.out.println("===============从redis缓存中获得数据===============");
        }
        System.out.println(userListData);
    }
}
