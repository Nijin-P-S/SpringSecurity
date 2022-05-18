package com.example.Spring_Security;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//To save the credentials in Database, need to import UserDetails and implement akk the methods in it
public class MyUser implements UserDetails {

    private static final String DELIMITER = ":";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    private String authorities; //deploy:monmitor:support   -> : is the delimiter can be , , * , ?, etc

    //authority required because without that cannot do authorization
    /*
        1. A single user can have multiple authorities (DEVELOPER , DEVOPS)
        2.
     */

//    private boolean accountExpired;
//    private boolean accountLocked;
//    private boolean credentialsLocked;
//    private boolean enabled;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] authority_list = this.authorities.split(DELIMITER);

        return Arrays.stream(authority_list)
                .map(x -> new SimpleGrantedAuthority(x))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;   //We are not considering the case of account expiry now, if given False, we will not be able to login.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  //Manages case of account locking due to malicious activity etc
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
