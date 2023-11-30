package com.vinhveer.studentmanagementapi.Repository;

import com.vinhveer.studentmanagementapi.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
