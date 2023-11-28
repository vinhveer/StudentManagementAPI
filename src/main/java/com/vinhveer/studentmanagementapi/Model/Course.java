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
    private long courseId;

    @Column
    private String courseName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId",
            foreignKey = @ForeignKey(name = "fk_subject_id_course",
                    foreignKeyDefinition = "FOREIGN KEY (subject_id) REFERENCES subject (subject_id) ON DELETE CASCADE ON UPDATE CASCADE"))
    private Subject subject;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teacherId", referencedColumnName = "teacherId",
            foreignKey = @ForeignKey(name = "fk_teacher_id_course",
                    foreignKeyDefinition = "FOREIGN KEY (teacher_id) REFERENCES teacher (teacher_id) ON DELETE CASCADE ON UPDATE CASCADE"))
    private Teacher teacher;
}
