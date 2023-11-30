package com.vinhveer.studentmanagementapi.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private long courseId;

    private String courseName;

    private long subjectId;

    private long teacherId;
}
