package com.leo.keepboot.service;


import com.leo.keepboot.model.Role;

import java.util.List;

/**
 * Description:
 * Created by Liuq on 2019-11-06.
 */
public interface RoleService {
    Role getRole(Long id);

    int deleteRole(Long id);

    Role insertRole(Role role);

    Role updateRole(Role role);

    List<Role> findRoles(String roleName, String note);
}

