package com.vinhveer.studentmanagementapi.Service.Implement;

import com.vinhveer.studentmanagementapi.Model.Subject;
import com.vinhveer.studentmanagementapi.Payload.Request.SubjectRequest;
import com.vinhveer.studentmanagementapi.Payload.Response.ListDataResponse;
import com.vinhveer.studentmanagementapi.Repository.SubjectRepository;
import com.vinhveer.studentmanagementapi.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImplement implements SubjectService
{
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public ResponseEntity<Object> GetAllSubject()
    {
        try
        {
            List<Subject> subjectList = subjectRepository.findAll();
            ListDataResponse<Object> listDataResponse = ListDataResponse.builder()
                    .message("Query successful.").data(subjectList).build();
            return ResponseEntity.ok(listDataResponse);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }
    }

    @Override
    public ResponseEntity<Object> AddSubject(SubjectRequest subjectRequest)
    {
        try
        {
            Subject subject = Subject.builder()
                    .subjectName(subjectRequest.getSubjectName())
                    .credit(subjectRequest.getCredit())
                    .build();

            subjectRepository.save(subject);
            return ResponseEntity.ok("Subject added sucessfully!");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }
    }

    @Override
    public ResponseEntity<Object> GetSubjectByID(long id)
    {
        try
        {
            Optional<Subject> subjectOptional = subjectRepository.findById(id);

            if (subjectOptional.isPresent())
            {
                Subject subject = subjectOptional.get();
                return ResponseEntity.ok().body(subject);
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Subject not found with id: " + id);
            }
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }

    }

    @Override
    public ResponseEntity<Object> DeleteSubjectByID(long id)
    {
        try
        {
            subjectRepository.deleteById(id);
            return ResponseEntity.ok("Subject delete successful.");

        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }
    }

    @Override
    public ResponseEntity<Object> EditSubjectByID(SubjectRequest subjectRequest, long id)
    {
        try
        {
            Optional<Subject> existingSubjectOptional = subjectRepository.findById(id);
            if (existingSubjectOptional.isPresent())
            {
                Subject updateSubject = existingSubjectOptional.get();
                updateSubject.setSubjectName(subjectRequest.getSubjectName());
                updateSubject.setCredit(subjectRequest.getCredit());

                subjectRepository.save(updateSubject);

                return ResponseEntity.ok("Subject updated sucessfully!");
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subject not found!");
            }
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }
    }
}
