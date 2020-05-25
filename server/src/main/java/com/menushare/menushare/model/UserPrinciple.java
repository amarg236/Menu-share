package com.menushare.menushare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class UserPrinciple implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String username;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrinciple(Long id, String name, String username,String password, Collection<? extends GrantedAuthority> authorities ) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }


    public static UserPrinciple create(User user){
        //to retrive list of roles for particular user
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role->
                new SimpleGrantedAuthority(role.getRoleName().name())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                user.getId(),
                user.getFirstname()+" "+user.getLastname(),
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o){
        if(this== o)
            return true;
        if(o == null|| getClass()!=o.getClass())
            return false;
        User that = (User) o;
        return Objects.equals(id,that.getId());
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(id);
    }
}
