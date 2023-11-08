package com.merylpor.microblog;

import com.merylpor.microblog.entity.UserEntity;
import com.merylpor.microblog.service.UserService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Optional;

@SpringBootTest
class MicroblogApplicationTests {

	@Autowired
	private UserService userService;


	@Test
	void contextLoads() {
	}

	@Test
	public void checkAddUser() {
//		UserEntity user = UserEntity.builder()
//				.username("capo")
//				.name("Rafo")
//				.createDate(Instant.now())
//				.build();
//		userService.saveUser(user);
		UserEntity userTest = userService.getUserByUsername("gmalka").orElse(null);
		assertNotNull(userTest);
		assertEquals(userTest.getUsername(),"gmalka");
//		assertEquals(userTest.getName(), user.getName());
//		userService.deleteUser(user);
	}

}
