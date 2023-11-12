package com.merylpor.microblog;

import com.merylpor.microblog.entity.PostsEntity;
import com.merylpor.microblog.entity.UserEntity;
import com.merylpor.microblog.repository.PostsRepository;
import com.merylpor.microblog.service.LoggingManagerService;
import com.merylpor.microblog.service.PostService;
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

	@Autowired
	private PostService postService;

	@Autowired
	private LoggingManagerService loggingManagerService;


	@Test
	void contextLoads() {
	}

	@Test
	public void checkAddUser() {
		UserEntity user = UserEntity.builder()
				.username("lola")
				.name("Roma")
				.createDate(Instant.now())
				.build();
		userService.saveUser(user);
		UserEntity userTest = userService.getUserByUsername(user.getUsername()).orElse(null);
		assertNotNull(userTest);
		assertEquals(userTest.getUsername(), user.getUsername());
		assertEquals(userTest.getName(), user.getName());
		userService.deleteUser(user.getId());
	}

	@Test
	public void checkAddPosts() {
		UserEntity codela = userService.getUserById(1L).orElse(null);
		UserEntity merylpor = userService.getUserById(2L).orElse(null);
		UserEntity gmalka = userService.getUserById(3L).orElse(null);

		loggingManagerService.setUser(codela);

//		postService.postCreate("Hello Im Backend Developer");
		postService.postCreate("Cocacola");
		postService.postCreate("nokia");

		loggingManagerService.setUser(merylpor);
		postService.postCreate("Vkontakte");
		postService.postCreate("MTS");

		loggingManagerService.setUser(gmalka);
		postService.postCreate("bobobobo");
		postService.postCreate("loloo");
		postService.postCreate("okenawa");
		postService.postCreate("Russia");

	}

}
