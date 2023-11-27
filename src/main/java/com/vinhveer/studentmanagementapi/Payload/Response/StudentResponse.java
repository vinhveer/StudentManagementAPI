package com.vinhveer.studentmanagementapi.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private long id;

    private String first_name;

    private String last_name;

    private Date date_of_birth;

    private String address;

    private String email;

    private String phone;
}
