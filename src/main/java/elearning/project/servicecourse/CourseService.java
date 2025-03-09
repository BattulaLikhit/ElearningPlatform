package elearning.project.servicecourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import elearning.project.models.Course;
import elearning.project.repositories.CourseRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}