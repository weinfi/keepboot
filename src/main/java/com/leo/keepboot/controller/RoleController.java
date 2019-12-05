package com.leo.keepboot.controller;

import com.leo.keepboot.model.Role;
import com.leo.keepboot.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Created by Liuq on 2019-08-21.
 */
@Controller
@RequestMapping()
public class RoleController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleService roleService;
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public Role add(){
        Role role = new Role();
        role.setRoleName("leo");
        role.setNote("lisa");
        Role role1 = roleService.insertRole(role); //reids中缓存了key=redis_role_67，值为role对象
        redisTemplate.opsForValue().set("role",role);
        logger.info("add req: " + role.toString());
        return role1;
    }
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    private Role detail(@PathVariable("id") Long id) {
        Role role = roleService.getRole(id);
        return role;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    private void a(){
        int i =1/0;
    }
}
