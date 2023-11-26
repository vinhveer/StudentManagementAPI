package com.vinhveer.studentmanagementapi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long student_id;

    @OneToOne
    @JoinColumn(name = "personal_id", foreignKey = @ForeignKey(name = "fk_personal_id_student",
            foreignKeyDefinition = "FOREIGN KEY (personal_id) REFERENCES personal (id) ON DELETE CASCADE ON UPDATE CASCADE"))
    private Personal personal;
}
