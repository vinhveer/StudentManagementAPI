package com.vinhveer.studentmanagementapi.Repository;

import com.vinhveer.studentmanagementapi.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
