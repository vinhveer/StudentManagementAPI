package com.vinhveer.studentmanagementapi.Service;

import com.vinhveer.studentmanagementapi.Payload.Request.TeacherRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    ResponseEntity<Object> GetAllTeacher();

    ResponseEntity<Object> AddTeacher(TeacherRequest teacherRequest);

    ResponseEntity<Object> GetTeacherByID(long id);

    ResponseEntity<Object> DeleteTeacherByID(long id);

    ResponseEntity<Object> EditTeacherByID(TeacherRequest teacherRequest, long id);
}
