package com.example.relationship.repository;

import com.example.relationship.model.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends CrudRepository<Subject, Long> {
}
