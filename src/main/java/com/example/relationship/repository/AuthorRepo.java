package com.example.relationship.repository;

import com.example.relationship.dto.AuthorDTO;
import com.example.relationship.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Long> {

    @Query("select a from Author a where a.id = ?1") // JPQL
    AuthorDTO getById(long id);

    @Query(value = "select * from author where id = ?1", nativeQuery = true) // Consulta nativa do SQL.
    Author getNativeById(long id);

    @Query("select a from Author a left join fetch a.address where a.id = :id") // JPQL
    AuthorDTO getDTOEagle(long id);
}
