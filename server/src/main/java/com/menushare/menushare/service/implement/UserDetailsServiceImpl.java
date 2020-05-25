package com.menushare.menushare.service.implement;

import com.menushare.menushare.model.User;
import com.menushare.menushare.model.UserPrinciple;
import com.menushare.menushare.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepo userRepo;

    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException(username);
        }
        return UserPrinciple.create(user);
    }

//    Save user below
    public User save(User user)
    {
        return userRepo.save(user);
    }
}
