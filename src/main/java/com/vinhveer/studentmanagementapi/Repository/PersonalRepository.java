package com.vinhveer.studentmanagementapi.Repository;

import com.vinhveer.studentmanagementapi.Model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Long> {
}
