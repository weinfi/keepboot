package com.leo.keepboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Description:
 * Created by Liuq on 2019-11-18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
    @Autowired
    private StringRedisTemplate redisTemplate;

/*    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }*/

    @Test
    public void contextLoads() {
/*        Role role = new Role();
        role.setRoleName("李华");
        role.setNote("好人");
        redisTemplate.opsForValue().set("role", role);
        Role role1 = (Role) redisTemplate.opsForValue().get("role");
        System.out.println(role1);*/
        redisTemplate.opsForValue().set("set1","hello");

    }
}
