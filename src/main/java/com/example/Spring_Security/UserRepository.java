package com.example.Spring_Security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<MyUser, Integer> {

    //Optional as the function name is in respect to hibernate 
    // @Query("select u from MyUser u where u.username = :s")
    MyUser findByUsername(String s);
}
