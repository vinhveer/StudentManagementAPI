package com.vinhveer.studentmanagementapi.Repository;

import com.vinhveer.studentmanagementapi.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
