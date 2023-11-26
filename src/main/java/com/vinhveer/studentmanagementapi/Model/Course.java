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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long course_id;

    @Column
    private String course_name;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id",
            foreignKey = @ForeignKey(name = "fk_subject_id_course",
                    foreignKeyDefinition = "FOREIGN KEY (subject_id) REFERENCES subject (subject_id) ON DELETE CASCADE ON UPDATE CASCADE"))
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id",
            foreignKey = @ForeignKey(name = "fk_teacher_id_course",
                    foreignKeyDefinition = "FOREIGN KEY (teacher_id) REFERENCES teacher (teacher_id) ON DELETE CASCADE ON UPDATE CASCADE"))
    private Teacher teacher;
}
