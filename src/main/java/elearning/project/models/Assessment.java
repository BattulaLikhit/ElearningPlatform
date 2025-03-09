package elearning.project.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assessment {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assessmentID;

	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;

	private Type type;
	private int maxScore;

	@OneToMany(mappedBy = "assessment",cascade = CascadeType.ALL)
	private List<Submission> sub;

	public enum Type {
		QUIZ, ASSIGNMENT
	}
}