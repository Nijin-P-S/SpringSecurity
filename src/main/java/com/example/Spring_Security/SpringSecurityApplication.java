package com.example.Spring_Security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String nijin = bCryptPasswordEncoder.encode("nijin123");
		System.out.println(nijin);
		String abc = bCryptPasswordEncoder.encode("abc123");
		System.out.println(abc);
	}

}
