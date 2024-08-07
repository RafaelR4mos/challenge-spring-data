package com.dbc.techup.challenge.spring.data.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateDTO {

    private String title;

    private String publisher;

    private String author;

    private String isbn;

    @Positive
    private Double price;
}
