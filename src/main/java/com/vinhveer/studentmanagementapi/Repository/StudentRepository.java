package com.vinhveer.studentmanagementapi.Repository;

import com.vinhveer.studentmanagementapi.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
