package com.menushare.menushare.repo;

import com.menushare.menushare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
