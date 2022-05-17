package com.example.Spring_Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    //Security context is kind of map which contains all the credentials with its corresponding details

    //This API should be invoked only by those having user authority
    @GetMapping("/user/hello")
    public String sayUserHello(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return "Hello User : "+ user.getUsername() ;
    }

    //This API should be invoked only by those having admin authority
    @GetMapping("/admin/hello")
    public String sayAdminHello(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return "Hello Admin : "+ user.getUsername() ;
    }

    //This API should be invoked  by anyone without even logging in
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Guest!!!";
    }
}
