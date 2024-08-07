package com.dbc.techup.challenge.spring.data.demo.controller;

import com.dbc.techup.challenge.spring.data.demo.dto.BookCreateDTO;
import com.dbc.techup.challenge.spring.data.demo.dto.BookDTO;
import com.dbc.techup.challenge.spring.data.demo.dto.BookUpdateDTO;
import com.dbc.techup.challenge.spring.data.demo.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDTO> findById(@PathVariable Long bookId) throws Exception {
        return new ResponseEntity<>(bookService.findById(bookId), HttpStatus.OK);
    }

    @GetMapping("/bytitle")
    public ResponseEntity<List<BookDTO>> findAllByTitle(@RequestParam String title) {
        return new ResponseEntity<>(bookService.findAllByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/bytitle-custom")
    public ResponseEntity<List<BookDTO>> findAllByTitleCustom(@RequestParam String title) {
        return new ResponseEntity<>(bookService.findAllByTitleCustom(title), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> create(@Valid @RequestBody BookCreateDTO bookCreateDTO) {
        return new ResponseEntity<>(bookService.create(bookCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookDTO> update(@PathVariable Long bookId, @Valid @RequestBody BookUpdateDTO bookUpdateDTO) throws Exception {
        return new ResponseEntity<>(bookService.update(bookId, bookUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> delete(@PathVariable Long bookId) throws Exception {
        bookService.delete(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
