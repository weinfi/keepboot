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
     * value = "redisCacheManager"��ʾʹ�õĻ������ƣ�����ʹ�õ���RedisConfig�����õĻ�����������ƣ�
     * key = "'redis_role_'+#id" ��ʾ���浽redisʱ��key
     *
     * @Cacheable ��ʾ��ִ��getRole()����ǰ���ȵ�redis��ѯ��Ӧkey�Ļ��棬
     * �����ڻ�����ֱ�ӷ��ػ��棻
     * �����治���ڣ���ִ�����ݿ��ѯ���룬Ȼ�󽫽�����浽redis����keyΪ"'redis_role_'+#id"��
     * ����@Cacheable �ʺϷ��ڲ�ѯ�����ʸߵķ�����
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    @Cacheable(value = "redisCacheManager", key = "'redis_role_'+#id")
    public Role getRole(Long id) {
        return roleMapper.getRole(id);
    }

    /**
     * @CachePut �� ������û�л��棬insertRole()���붼��ȥִ�У�Ȼ�󽫷��صĽ�����浽redis�С�
     * ����@CachePut �ʺϷ��ڲ���͸������ݿ�ķ����ϡ�
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    @CachePut(value="redisCacheManager",key="'redis_role_'+#role.id")
    public Role insertRole(Role role) {
        roleMapper.insertRole(role);
        return role;
    }

    /**
     * @CacheEvict ��ʾɾ��redis�еĻ��棬����ɾ����ʱkey="'redis_role_'+#id"�Ļ���
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

