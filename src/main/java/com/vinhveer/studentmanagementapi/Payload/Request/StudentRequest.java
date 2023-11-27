package com.vinhveer.studentmanagementapi.Payload.Request;

import lombok.Data;
import java.util.Date;

@Data
public class StudentRequest {
    private long id;

    private String first_name;

    private String last_name;

    private Date date_of_birth;

    private String address;

    private String email;

    private String phone;
}
