package com.danny.Taxifa;

import com.danny.Taxifa.entities.User;
import com.danny.Taxifa.repositories.UserRepository;
import com.danny.Taxifa.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;



@SpringBootTest
class TaxifaApplicationTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void getSaveUser() {
		User  u = new User(1,"gam","562356","gam","gam","gam", LocalDate.now());

		Assertions.assertSame(u.getId(),1);


	}

}
