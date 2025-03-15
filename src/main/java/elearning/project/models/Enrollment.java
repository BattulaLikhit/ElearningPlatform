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
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long enrollmentId;
    private Double progress;

    @ManyToOne
    @JoinColumn(name = "studentId")
    @JsonBackReference(value="student-enrollment")
    private User studentId;

    @ManyToOne
    @JoinColumn(name = "courseId")
    @JsonBackReference(value="course-enrollment")
    private Course course;

}