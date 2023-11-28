package com.vinhveer.studentmanagementapi.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private long id;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String address;

    private String email;

    private String phone;
}
