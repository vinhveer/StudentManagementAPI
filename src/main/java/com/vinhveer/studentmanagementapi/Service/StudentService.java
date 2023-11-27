package com.vinhveer.studentmanagementapi.Service;

import com.vinhveer.studentmanagementapi.Payload.Request.StudentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    ResponseEntity<Object> GetAllStudent();

    ResponseEntity<Object> AddStudent(StudentRequest studentRequest);

    ResponseEntity<Object> GetStudentByID(long id);

    ResponseEntity<Object> DeleteStudentByID(long id);

    ResponseEntity<Object> EditStudentByID(StudentRequest studentRequest, long id);
}
