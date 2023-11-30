package com.vinhveer.studentmanagementapi.Service.Implement;

import com.vinhveer.studentmanagementapi.Payload.Request.CourseRequest;
import com.vinhveer.studentmanagementapi.Service.CourseService;
import org.springframework.http.ResponseEntity;

public class CourseServiceImplement implements CourseService {
    @Override
    public ResponseEntity<Object> GetAllCourse() {
        return null;
    }

    @Override
    public ResponseEntity<Object> AddCourse(CourseRequest courseRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Object> GetCourseByID(long id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> DeleteCourseByID(long id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> EditCourseByID(CourseRequest courseRequest, long id) {
        return null;
    }
}
