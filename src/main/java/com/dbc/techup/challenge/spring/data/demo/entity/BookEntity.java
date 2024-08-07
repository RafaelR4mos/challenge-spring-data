package com.dbc.techup.challenge.spring.data.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_book")
    @SequenceGenerator(name = "seq_book", sequenceName = "seq_book_db", allocationSize = 1)
    @Column(name = "id_book")
    private Long idBook;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "price")
    private Double price;

    public BookEntity(String title, String author, String publisher, String isbn, Double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.price = price;
    }
}
