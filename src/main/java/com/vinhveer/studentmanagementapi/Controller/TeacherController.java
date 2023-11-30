package com.vinhveer.studentmanagementapi.Controller;

import com.vinhveer.studentmanagementapi.Payload.Request.TeacherRequest;
import com.vinhveer.studentmanagementapi.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/")
    public String Hello() {
        return "Hello, world!";
    }

    @PostMapping("/add")
    public ResponseEntity<Object> AddTeacher(@RequestBody TeacherRequest teacherRequest)
    {
        return teacherService.AddTeacher(teacherRequest);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> GetAllTeacher()
    {
        return teacherService.GetAllTeacher();
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity<Object> GetTeacherByID(@PathVariable long id)
    {
        return teacherService.GetTeacherByID(id);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<Object> DeleteTeacherByID(@PathVariable long id)
    {
        return teacherService.DeleteTeacherByID(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> EditTeacherByID(@RequestBody TeacherRequest teacherRequest, @PathVariable long id)
    {
        return teacherService.EditTeacherByID(teacherRequest, id);
    }
}
