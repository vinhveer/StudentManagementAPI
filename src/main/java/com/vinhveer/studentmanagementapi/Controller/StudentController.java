package com.vinhveer.studentmanagementapi.Controller;

import com.vinhveer.studentmanagementapi.Payload.Request.StudentRequest;
import com.vinhveer.studentmanagementapi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    private String Hello()
    {
        return "Hello, world!";
    }

    @PostMapping("/add")
    public ResponseEntity<Object> AddStudent(@RequestBody StudentRequest studentRequest)
    {
        return studentService.AddStudent(studentRequest);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> GetAllStudent()
    {
        return studentService.GetAllStudent();
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity<Object> GetStudentByID(@PathVariable long id)
    {
        return studentService.GetStudentByID(id);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<Object> DeleteStudentByID(@PathVariable long id)
    {
        return studentService.DeleteStudentByID(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> EditStudentByID(@RequestBody StudentRequest studentRequest, @PathVariable Long id)
    {
        return studentService.EditStudentByID(studentRequest, id);
    }
}
