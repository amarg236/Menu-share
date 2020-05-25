package com.menushare.menushare.service.implement;

import com.menushare.menushare.model.Role;
import com.menushare.menushare.model.RoleName;
import com.menushare.menushare.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImplementation {
    @Autowired
    RoleRepo roleRepo;

    public Role findByRoleName(RoleName rName){
        System.out.println("service>>"+rName);
        System.out.println(roleRepo.findByRoleName(rName));
        return roleRepo.findByRoleName(rName).orElseThrow(()->new RuntimeException("Fail! - Cause : User Role not find."));
    }
}
