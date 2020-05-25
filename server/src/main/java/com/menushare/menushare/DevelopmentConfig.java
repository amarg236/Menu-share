//package com.menushare.menushare;
//
//import com.menushare.menushare.model.Role;
//import com.menushare.menushare.model.RoleName;
//import com.menushare.menushare.repo.RoleRepo;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DevelopmentConfig {
//    @Bean
//    public CommandLineRunner dataLoader(RoleRepo roleRepo){
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                roleRepo.save(new Role(RoleName.ROLE_USER));
//                roleRepo.save(new Role(RoleName.ROLE_OWNER));
//                roleRepo.save(new Role(RoleName.ROLE_ADMIN));
//            }
//        };
//    }
//}
