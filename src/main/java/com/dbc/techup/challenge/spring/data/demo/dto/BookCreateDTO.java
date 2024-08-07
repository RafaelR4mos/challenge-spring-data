package com.dbc.techup.challenge.spring.data.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class BookCreateDTO {

    @NotNull
    private String title;

    @NotNull
    private String publisher;

    @NotNull
    private String author;

    @NotNull
    private String isbn;

    @NotNull
    @Positive
    private Double price;
}
