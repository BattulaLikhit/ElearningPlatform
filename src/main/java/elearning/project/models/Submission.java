package elearning.project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Submission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long submissionId;
	private Double score;

	@ManyToOne
	@JoinColumn(name = "assessmentId")
	@JsonBackReference
	private Assessment assessment;

	@ManyToOne
	@JoinColumn(name = "studentId")
	@JsonBackReference
	private User user;

}