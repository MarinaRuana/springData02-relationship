package com.example.relationship.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "author", cascade = CascadeType.ALL) // author = nome do campo na tabela Address que é usado como referência.
    @JsonIgnoreProperties("author") // Ao preencher os dados do Address, não traga os dados do Author.
    private Address address;

    @ManyToMany
    @JoinTable(name = "book_author", // Nome da tabela de ligação
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"), // Atributo do livro na tabela de ligação.
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id")) // Atributo do livro na tabela de ligação.

    @JsonIgnoreProperties("authors")
    private List<Book> books;
}
