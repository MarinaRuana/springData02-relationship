package com.example.relationship.controller;

import com.example.relationship.dto.AuthorDTO;
import com.example.relationship.model.Author;
import com.example.relationship.repository.AuthorRepo;
import com.example.relationship.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepo repo;

    @Autowired
    private AuthorService service;

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable long id){
        return ResponseEntity.ok(repo.findById(id).get());
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<AuthorDTO> getDTOById(@PathVariable long id){
        return ResponseEntity.ok(repo.getById(id));
    }

    @GetMapping("/native/{id}")
    public ResponseEntity<Author> getNativeById(@PathVariable long id){
        return ResponseEntity.ok(repo.getNativeById(id));
    }

    @GetMapping("/eagle/{id}")
    public ResponseEntity<AuthorDTO> getEagleById(@PathVariable long id){
        return ResponseEntity.ok(repo.getDTOEagle(id));
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author newAuthor){
        return ResponseEntity.ok(service.save(newAuthor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorDTO> deleteById(@PathVariable long id){
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
