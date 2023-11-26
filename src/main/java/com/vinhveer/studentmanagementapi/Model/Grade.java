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
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long grade_id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id",
            foreignKey = @ForeignKey(name = "fk_student_id_grade",
            foreignKeyDefinition = "FOREIGN KEY (student_id) REFERENCES student (student_id) ON DELETE CASCADE ON UPDATE CASCADE"))
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id",
            foreignKey = @ForeignKey(name = "fk_course_id_grade",
                    foreignKeyDefinition = "FOREIGN KEY (course_id) REFERENCES course (course_id) ON DELETE CASCADE ON UPDATE CASCADE"))
    private Course course;

    @Column
    private double process_grade;

    @Column
    private double midterm_grade;

    @Column
    private double final_grade;
}