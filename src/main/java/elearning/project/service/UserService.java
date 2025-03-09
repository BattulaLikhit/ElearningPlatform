package elearning.project.service;

import elearning.project.models.User;
import elearning.project.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById( int id) {
		return userRepository.findById(id);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(int id, User userDetails) {
		User user = getUserById(id).get();
		user.setName(userDetails.getName());
		user.setEmail(userDetails.getEmail());
		user.setRole(userDetails.getRole());
		return userRepository.save(user);
	}

	public void deleteUser(int id) {
		User user = getUserById(id).get();
		userRepository.delete(user);
	}

}