package elearning.project.serviceuser;

import elearning.project.models.User;
import elearning.project.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepo userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById( Long id) {
		return userRepository.findById(id);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User userDetails) {
		Optional<User> optionaluser = getUserById(id);
		//Exception must be handled
		User user=optionaluser.get();
		user.setName(userDetails.getName());
		user.setEmail(userDetails.getEmail());
		user.setRole(userDetails.getRole());
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		User user = getUserById(id).get();
		userRepository.delete(user);
	}

}