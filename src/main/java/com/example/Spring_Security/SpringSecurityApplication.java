package com.example.Spring_Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Value("${ADMIN_AUTHORITY}")
	private String ADMIN_AUTHORITY;

	@Value("${USER_ATTENDANCE_AUTHORITY}")
	private String USER_ATTENDANCE_AUTHORITY;

	@Value("{USER_ONLY_AUTHORITY}")
	private String USER_ONLY_AUTHORITY;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);

//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		String nijin = bCryptPasswordEncoder.encode("nijin123");
//		System.out.println(nijin);
//		String abc = bCryptPasswordEncoder.encode("abc123");
//		System.out.println(abc);
	}

//	After starting the application this run function will execute
	@Override
	public void run(String... args) throws Exception {
		//Here we can define basic operations that you can do when the application starts
		//Like deleting local files
		//Implemented here because of the requirement of non static objects, that cannot be done in main() since it is static

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		MyUser myUser = MyUser.builder()
				.username("Nijin")
				.password(bCryptPasswordEncoder.encode("Nijin123"))
				.authorities(ADMIN_AUTHORITY+":"+USER_ATTENDANCE_AUTHORITY)
				.build();

		userRepository.save(myUser);
	}
}
