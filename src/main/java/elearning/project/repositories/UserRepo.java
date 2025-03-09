package elearning.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import elearning.project.models.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	 
}
