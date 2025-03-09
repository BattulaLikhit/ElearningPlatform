package elearning.project.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

//@RestControllerAdvice
public class ApplicationExceptionHnadler {
//	@ExceptionHandler(exception=ResourceIdNotFoundException.class)
	public ResponseEntity<?> resourseIdNotFoundException(ResourceIdNotFoundException ex,HttpServletRequest request){
		//need to handle
		return null;
	}

}
