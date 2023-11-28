package com.vinhveer.studentmanagementapi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teacherId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personalId", foreignKey = @ForeignKey(name = "fk_personal_id_teacher",
            foreignKeyDefinition = "FOREIGN KEY (personal_id) REFERENCES personal (id) ON DELETE CASCADE ON UPDATE CASCADE"))
    private Personal personal;
}
