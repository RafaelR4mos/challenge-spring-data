package com.dbc.techup.challenge.spring.data.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long idBook;
    private String title;
    private String publisher;
    private String author;
    private String isbn;
    private Double price;
}
