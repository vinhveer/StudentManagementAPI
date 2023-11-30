package com.vinhveer.studentmanagementapi.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponse {
    private long subjectId;

    private String subjectName;

    private int credit;
}
