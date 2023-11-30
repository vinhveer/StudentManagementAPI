package com.vinhveer.studentmanagementapi.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {
    private long courseId;

    private String courseName;

    private long subjectId;

    private long teacherId;
}
