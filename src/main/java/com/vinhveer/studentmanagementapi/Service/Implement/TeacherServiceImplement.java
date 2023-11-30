package com.vinhveer.studentmanagementapi.Service.Implement;

import com.vinhveer.studentmanagementapi.Model.Personal;
import com.vinhveer.studentmanagementapi.Model.Teacher;
import com.vinhveer.studentmanagementapi.Payload.Request.TeacherRequest;
import com.vinhveer.studentmanagementapi.Payload.Response.ListDataResponse;
import com.vinhveer.studentmanagementapi.Repository.PersonalRepository;
import com.vinhveer.studentmanagementapi.Repository.TeacherRepository;
import com.vinhveer.studentmanagementapi.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImplement implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    PersonalRepository personalRepository;

    @Override
    public ResponseEntity<Object> GetAllTeacher()
    {
        try
        {
            List<Teacher> teachers = teacherRepository.findAll();
            ListDataResponse<Object> listDataResponse = ListDataResponse.builder()
                    .message("Query successful.").data(teachers).build();
            return ResponseEntity.ok(listDataResponse);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }
    }

    @Override
    public ResponseEntity<Object> AddTeacher(TeacherRequest teacherRequest)
    {
        try
        {
            Personal personal = Personal.builder()
                    .firstName(teacherRequest.getFirstName())
                    .lastName(teacherRequest.getLastName())
                    .dateOfBirth(teacherRequest.getDateOfBirth())
                    .address(teacherRequest.getAddress())
                    .email(teacherRequest.getEmail())
                    .phone(teacherRequest.getPhone()).build();

            personalRepository.save(personal);

            Teacher teacher = Teacher.builder().personal(personal).build();

            teacherRepository.save(teacher);

            return ResponseEntity.ok("Teacher added sucessfully!");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }
    }

    @Override
    public ResponseEntity<Object> GetTeacherByID(long id)
    {
        try
        {
            Optional<Teacher> teacherOptional = teacherRepository.findById(id);

            if (teacherOptional.isPresent())
            {
                Teacher teacher = teacherOptional.get();
                return ResponseEntity.ok().body(teacher);
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Student not found with ID: " + id);
            }
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }
    }

    @Override
    public ResponseEntity<Object> DeleteTeacherByID(long id) {
        try
        {
            teacherRepository.deleteById(id);
            return ResponseEntity.ok("Teacher deleted successfully!");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }
    }

    @Override
    public ResponseEntity<Object> EditTeacherByID(TeacherRequest teacherRequest, long id)
    {
        try
        {
            Optional<Teacher> existingTeacherOptional = teacherRepository.findById(id);
            if (existingTeacherOptional.isPresent())
            {
                Teacher existingTeacher = existingTeacherOptional.get();

                Personal updatedPersonal = existingTeacher.getPersonal();
                updatedPersonal.setFirstName(teacherRequest.getFirstName());
                updatedPersonal.setLastName(teacherRequest.getLastName());
                updatedPersonal.setDateOfBirth(teacherRequest.getDateOfBirth());
                updatedPersonal.setAddress(teacherRequest.getAddress());
                updatedPersonal.setEmail(teacherRequest.getEmail());
                updatedPersonal.setPhone(teacherRequest.getPhone());

                teacherRepository.save(existingTeacher);

                return ResponseEntity.ok("Teacher updated sucessfully");
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Teacher not found!");
            }
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }
    }
}
