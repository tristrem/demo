package com.example.demo_jpa;

import com.example.demo_jpa.domain.User;
import com.example.demo_jpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoJpaApplication.class)
class DemoJpaApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
		List<User> list = userRepository.findAll();
		System.out.println(list);
		System.out.println(list);
		System.out.println(list);

	}

}
