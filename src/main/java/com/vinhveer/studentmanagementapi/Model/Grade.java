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
    private long gradeId;

//    @Column
//    private long studentId;
//
//    @Column
//    private long courseId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId",
            foreignKey = @ForeignKey(name = "fk_student_id_grade",
            foreignKeyDefinition = "FOREIGN KEY (student_id) REFERENCES student (student_id) ON DELETE CASCADE ON UPDATE CASCADE"))
    private Student student;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "courseId", referencedColumnName = "courseId",
            foreignKey = @ForeignKey(name = "fk_course_id_grade",
                    foreignKeyDefinition = "FOREIGN KEY (course_id) REFERENCES course (course_id) ON DELETE CASCADE ON UPDATE CASCADE"))
    private Course course;

    @Column
    private double processGrade;

    @Column
    private double midtermGrade;

    @Column
    private double finalGrade;
}