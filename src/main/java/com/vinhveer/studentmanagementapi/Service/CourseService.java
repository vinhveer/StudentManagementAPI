package com.vinhveer.studentmanagementapi.Service;

import com.vinhveer.studentmanagementapi.Payload.Request.CourseRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    ResponseEntity<Object> GetAllCourse();
    ResponseEntity<Object> AddCourse(CourseRequest courseRequest);

    ResponseEntity<Object> GetCourseByID(long id);

    ResponseEntity<Object> DeleteCourseByID(long id);

    ResponseEntity<Object> EditCourseByID(CourseRequest courseRequest, long id);
}
