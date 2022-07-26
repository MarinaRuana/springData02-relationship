package com.example.relationship.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String location;

    @OneToOne
    @JoinColumn(name = "id_author") // Indica que será a chave estrangeira.
    private Author author;
}
