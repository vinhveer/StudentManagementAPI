package com.vinhveer.studentmanagementapi.Service;

import com.vinhveer.studentmanagementapi.Model.Subject;
import com.vinhveer.studentmanagementapi.Payload.Request.SubjectRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SubjectService {
    ResponseEntity<Object> GetAllSubject();

    ResponseEntity<Object> AddSubject(SubjectRequest subjectRequest);

    ResponseEntity<Object> GetSubjectByID(long id);

    ResponseEntity<Object> DeleteSubjectByID(long id);

    ResponseEntity<Object> EditSubjectByID(SubjectRequest subjectRequest, long id);
}
