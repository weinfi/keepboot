package com.leo.keepboot.service;

import com.leo.keepboot.dao.RoleMapper;
import com.leo.keepboot.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description:
 * Created by Liuq on 2019-11-06.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * value = "redisCacheManager"表示使用的缓存名称（这里使用的是RedisConfig中配置的缓存管理器名称）
     * key = "'redis_role_'+#id" 表示缓存到redis时的key
     *
     * @Cacheable 表示在执行getRole()代码前，先到redis查询对应key的缓存，
     * 若存在缓存则直接返回缓存；
     * 若缓存不存在，则执行数据库查询代码，然后将结果缓存到redis，其key为"'redis_role_'+#id"。
     * 所以@Cacheable 适合放在查询命中率高的方法上
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    @Cacheable(value = "redisCacheManager", key = "'redis_role_'+#id")
    public Role getRole(Long id) {
        return roleMapper.getRole(id);
    }

    /**
     * @CachePut ， 不管有没有缓存，insertRole()代码都会去执行，然后将返回的结果缓存到redis中。
     * 所以@CachePut 适合放在插入和更新数据库的方法上。
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    @CachePut(value="redisCacheManager",key="'redis_role_'+#role.id")
    public Role insertRole(Role role) {
        roleMapper.insertRole(role);
        return role;
    }

    /**
     * @CacheEvict 表示删除redis中的缓存，这里删除的时key="'redis_role_'+#id"的缓存
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    @CacheEvict(value="redisCacheManager", key="'redis_role_'+#id")
    public int deleteRole(Long id) {
        return roleMapper.deleteRole(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    @CachePut(value="redisCacheManager", key="'redis_role_'+#role.id")
    public Role updateRole(Role role) {
        roleMapper.updateRole(role);
        return role;
    }

    @Override
    public List<Role> findRoles(String roleName, String note) {
        return roleMapper.findRoles(roleName, note);
    }

}

