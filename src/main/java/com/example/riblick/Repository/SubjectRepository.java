package com.example.riblick.Repository;

import com.example.riblick.Entity.Subject;
import com.example.riblick.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByFormId(Long formId);
}
