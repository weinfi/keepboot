package com.leo.keepboot.dao;

import com.leo.keepboot.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 * Created by Liuq on 2019-11-06.
 */
@Mapper
public interface RoleMapper {
    Role getRole(Long id);

    int deleteRole(Long id);

    int insertRole(Role role);

    int updateRole(Role role);

    List<Role> findRoles(@Param("roleName") String roleName, @Param("note") String note);
}

