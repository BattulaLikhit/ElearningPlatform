package elearning.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int UserID;

	private String Name;

	@Enumerated(EnumType.STRING)
	private Role Role;

	@Column(unique = true)
	private String Email;
    
	private String Password;

	@OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL) //one user has many enrollments
	private List<Enrollment> eroll;

	@OneToMany(mappedBy = "InstructorId", cascade = CascadeType.ALL) // one user has many courses
	private List<Course> courses;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //one user has many submissions
	private List<Submission> submission;

	public enum Role {
		STUDENT, INSTRUCTOR
	}

}

