package org.dibyendu.jsfspring.service;

import java.util.List;
import java.util.Random;

import org.dibyendu.jsfspring.entity.User;
import org.dibyendu.jsfspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("userRegistrationService")
public class UserRegistrationService {

	@Autowired
	private UserRepository userRepository;
	
	public User isUserExist(String emailId) {
		User um = userRepository.findExistingEmailId(emailId);
		if(um != null) {
			return um;
		}else {
			return um;
		}
	}
	
	public User registerUser(String name, String password) {
		System.out.println("um = "+name);
		String uId = getUniqueUserId();
		User user = new User();
		user.setUserId(uId);
		user.setEmail(name);
		user.setPassword(password);
		User res = userRepository.save(user);
		if(res != null) {
			return res;
		}else {
			return res;
		}
	}
	
	public String getUniqueUserId() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	public String validateUser(String email, String password) {
		System.out.println("email "+email);
		List<User> userMaster = userRepository.findUserByEmailId(email);
		String userId = null;
		String userPassword = null;
		//String dbUserPassword = null;
		if(userMaster.size() > 0) {
			for(User user : userMaster) {
				userPassword = user.getPassword().toString();
			}
			
			if(password.equals(userPassword)) {
				for(User user : userMaster) {
					userId = String.valueOf(user.getUserId());
					System.out.println("userId "+userId);
				}
				return userId;
			}else {
				return userId;
			}
		}else {
			return userId;
		}
	}
}
