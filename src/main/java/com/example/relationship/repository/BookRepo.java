package com.example.relationship.repository;

import com.example.relationship.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
}
