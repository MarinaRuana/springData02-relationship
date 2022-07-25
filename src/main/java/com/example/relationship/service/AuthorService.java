package com.example.relationship.service;

import com.example.relationship.model.Author;
import com.example.relationship.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthorService implements IAuthorService{

    @Autowired
    private AuthorRepo repo;


    @Transactional // Faz rollback em caso de erro.
    @Override
    public Author save(Author newAuthor){
        newAuthor.getAddress().setAuthor(newAuthor);
        return repo.save(newAuthor);
    }
}
