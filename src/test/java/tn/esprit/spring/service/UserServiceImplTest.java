package tn.esprit.spring.service;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserServiceImplTest {
	@Autowired
	IUserService us;


    @Order(1)
	@Test
	public void testadduser(){
		User expected = new User("houssem", "ferjani" ,  new Date(), Role.ADMINISTRATEUR);
		User user = us.addUser(expected);
		Assertions.assertEquals(expected,user);
	}

	@Test
	@Order(2)
	public void testRetrieveAllUsers(){
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertTrue(listUsers.size()>= 1);
	}

	@Test
	@Order(3)
	public void testRetrieveUser(){
		User user = us.retrieveUser("2");
		Assertions.assertEquals(2,us.retrieveUser("2").getId());
	}
/*

	@Order(4)
	@Test
	public void deleteusertest(){
		 us.deleteUser("6");
		 User user = us.retrieveUser("6");
		Assertions.assertNull(user);


	}
*/
	@Order(4)
	@Test
	public void testmodifyuser(){
		User expected = new User(2L,"houssemferjani", "ferjani" ,  new Date(), Role.ADMINISTRATEUR);
		User user = us.updateUser(expected);
		Assertions.assertEquals(expected,user);
	}



}