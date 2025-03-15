package elearning.project.models;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userID;

	private String username;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(unique = true)
	private String email;
    
	private String password;

	@OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL) //one user has many enrollments
	@JsonManagedReference(value="student-enrollment")
	private List<Enrollment> eroll;

	@OneToMany(mappedBy = "instructorId", cascade = CascadeType.ALL) // one user has many courses
	@JsonManagedReference    // its the main annotation for avoiding the infinite recursion bw the entities  
	private Set<Course> courses;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //one user has many submissions
	@JsonManagedReference
	private List<Submission> submission;

	public enum Role {
		STUDENT, INSTRUCTOR
	}

}

