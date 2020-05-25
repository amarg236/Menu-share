package com.menushare.menushare.controller;

import com.menushare.menushare.controller.RequestBody.SignUpForm;
import com.menushare.menushare.model.Role;
import com.menushare.menushare.model.RoleName;
import com.menushare.menushare.model.User;
import com.menushare.menushare.repo.UserRepo;
import com.menushare.menushare.service.implement.RoleServiceImplementation;
import com.menushare.menushare.service.implement.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    RoleServiceImplementation roleServiceImplementation;

    @Autowired
    UserDetailsServiceImpl userService;

    private UserRepo userRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepo userRepo,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    @PostMapping("/sign-up")
    public void signUp(@Valid  @RequestBody SignUpForm signUpForm) {

        System.out.println("I have been executed");
        System.out.println(signUpForm);
        User user = new User(signUpForm.getFirstname(),signUpForm.getLastname(),signUpForm.getUsername(), signUpForm.getPassword());
        Set<String> userRoleSet = signUpForm.getRole();
        Set<Role> roles = new HashSet<>();
//        Set<Role> roleName = new HashSet<>();
        for (String each : userRoleSet) {
        System.out.println(each);
            if (each.equals("admin")) {
                Role adminRole = roleServiceImplementation.findByRoleName(RoleName.ROLE_ADMIN);
                roles.add(adminRole);
            } else if (each.equals("owner")) {
                Role ownerRole = roleServiceImplementation.findByRoleName(RoleName.ROLE_OWNER);
                roles.add(ownerRole);
            } else {
                Role roleOfUser = roleServiceImplementation.findByRoleName(RoleName.ROLE_USER);
                roles.add(roleOfUser);
            }
        }

        user.setRoles(roles);
        System.out.println("getRoles>>"+user.getRoles());
        user.setPassword(bCryptPasswordEncoder.encode(signUpForm.getPassword()));
        userService.save(user);

    }

}
