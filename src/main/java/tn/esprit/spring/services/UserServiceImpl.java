package tn.esprit.spring.services;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {


			l.info("start retrieve all users");
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				l.info("user : {}", user);
			} 
			l.info("all users retrieved");
		
		}catch (Exception e) {
	
			l.error("out with error"+e);
			
		}
		

		return users;
	}


	@Override
	public User addUser(User u) {
		l.info("ajouter");
		User u_saved = userRepository.save(u);
		l.info("user {} is created", u_saved);
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) {
		l.info("start modification");
		User u_saved = userRepository.save(u);
		l.info("user {} is modified as {} ", u, u_saved);
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		l.info("start deletion");
		userRepository.deleteById(Long.parseLong(id));
		l.info("user with id '{}' is deleted", id);
	}

	@Override
	public User retrieveUser(String id) {
		l.info("start retrieve");
		User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		l.info("user {} has been retrieved", u);
		return u; 
	}

}