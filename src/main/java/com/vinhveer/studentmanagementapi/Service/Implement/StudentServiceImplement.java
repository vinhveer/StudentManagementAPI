package com.vinhveer.studentmanagementapi.Service.Implement;

import com.vinhveer.studentmanagementapi.Model.Personal;
import com.vinhveer.studentmanagementapi.Model.Student;
import com.vinhveer.studentmanagementapi.Payload.Request.StudentRequest;
import com.vinhveer.studentmanagementapi.Payload.Response.ListDataResponse;
import com.vinhveer.studentmanagementapi.Repository.PersonalRepository;
import com.vinhveer.studentmanagementapi.Repository.StudentRepository;
import com.vinhveer.studentmanagementapi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplement implements StudentService
{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonalRepository personalRepository;

    @Override
    public ResponseEntity<Object> AddStudent(StudentRequest studentRequest) {
        try {
            Personal personal = Personal.builder()
                    .firstName(studentRequest.getFirstName())
                    .lastName(studentRequest.getLastName())
                    .dateOfBirth(studentRequest.getDateOfBirth())
                    .address(studentRequest.getAddress())
                    .email(studentRequest.getEmail())
                    .phone(studentRequest.getPhone())
                    .build();

            personalRepository.save(personal);

            Student newStudent = Student.builder()
                    .personal(personal)
                    .build();

            studentRepository.save(newStudent);

            return ResponseEntity.ok("Student added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }
    }

    @Override
    public ResponseEntity<Object> GetStudentByID(long id)
    {
        try
        {
            Optional<Student> studentOptional = studentRepository.findById(id);

            if (studentOptional.isPresent())
            {
                Student student = studentOptional.get();
                return ResponseEntity.ok().body(student);
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with ID: " + id);
            }

        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from the server with exception = " + e);
        }
    }


    @Override
    public ResponseEntity<Object> DeleteStudentByID(long id)
    {
        try
        {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted successfully");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }
    }

    @Override
    public ResponseEntity<Object> EditStudentByID(StudentRequest studentRequest, long id)
    {
        try
        {
            Optional<Student> existingStudentOptional = studentRepository.findById(id);
            if (existingStudentOptional.isPresent())
            {
                Student existingStudent = existingStudentOptional.get();

                Personal updatedPersonal = existingStudent.getPersonal();
                updatedPersonal.setFirstName(studentRequest.getFirstName());
                updatedPersonal.setLastName(studentRequest.getLastName());
                updatedPersonal.setDateOfBirth(studentRequest.getDateOfBirth());
                updatedPersonal.setAddress(studentRequest.getAddress());
                updatedPersonal.setEmail(studentRequest.getEmail());
                updatedPersonal.setPhone(studentRequest.getPhone());

                studentRepository.save(existingStudent);

                return ResponseEntity.ok("Student updated successfully");
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
            }
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }
    }

    @Override
    public ResponseEntity<Object> GetAllStudent()
    {
        try
        {
            List<Student> students = studentRepository.findAll();
            ListDataResponse<Object> listDataResponse = ListDataResponse.builder()
                    .message("Query successful.").data(students).build();
            return ResponseEntity.ok(listDataResponse);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }
    }
}
