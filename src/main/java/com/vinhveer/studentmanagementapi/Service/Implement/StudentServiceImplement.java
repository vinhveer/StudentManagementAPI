package com.vinhveer.studentmanagementapi.Service.Implement;

import com.vinhveer.studentmanagementapi.Payload.Request.StudentRequest;
import com.vinhveer.studentmanagementapi.Service.StudentService;
import org.springframework.http.ResponseEntity;

public class StudentServiceImplement implements StudentService {
    @Override
    public ResponseEntity<Object> GetAllStudent() {
        return null;
    }

    @Override
    public ResponseEntity<Object> AddStudent(StudentRequest studentRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Object> GetStudentByID(long id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> DeleteStudentByID(long id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> EditStudentByID(StudentRequest studentRequest, long id) {
        return null;
    }
}
