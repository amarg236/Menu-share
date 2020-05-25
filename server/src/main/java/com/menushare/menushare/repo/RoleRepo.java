package com.menushare.menushare.repo;

import com.menushare.menushare.model.Role;
import com.menushare.menushare.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface RoleRepo extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(RoleName roleName);
}
