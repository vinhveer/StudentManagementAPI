package com.vinhveer.studentmanagementapi.Controller;

import com.vinhveer.studentmanagementapi.Payload.Request.SubjectRequest;
import com.vinhveer.studentmanagementapi.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @RequestMapping("/")
    public String Hello()
    {
        return "Hello, world!";
    }

    @PostMapping("/add")
    public ResponseEntity<Object> AddSubject(SubjectRequest subjectRequest)
    {
        return subjectService.AddSubject(subjectRequest);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> GetAllSubject()
    {
        return subjectService.GetAllSubject();
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity<Object> GetSubjectByID(@PathVariable  long id)
    {
        return subjectService.GetSubjectByID(id);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<Object> DeleteSubjectByID(@PathVariable long id)
    {
        return subjectService.DeleteSubjectByID(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> EditSubjectByID(@RequestBody SubjectRequest subjectRequest, @PathVariable long id)
    {
        return subjectService.EditSubjectByID(subjectRequest, id);
    }
}
