package com.dbc.techup.challenge.spring.data.demo.service;

import com.dbc.techup.challenge.spring.data.demo.dto.BookCreateDTO;
import com.dbc.techup.challenge.spring.data.demo.dto.BookDTO;
import com.dbc.techup.challenge.spring.data.demo.dto.BookUpdateDTO;
import com.dbc.techup.challenge.spring.data.demo.entity.BookEntity;
import com.dbc.techup.challenge.spring.data.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<BookDTO> findAll() {
        List<BookDTO> booksDTO = bookRepository.findAll()
                .stream()
                .map(this::retornaDTO)
                .toList();

        return booksDTO;
    }

    public BookDTO findById(Long bookId) throws Exception {
        BookEntity bookEntity = bookRepository.findById(bookId).orElseThrow(() -> new Exception("Livro não encontrado."));

        return retornaDTO(bookEntity);
    }

    public List<BookDTO> findAllByTitle(String title) {
        List<BookDTO> booksDTO = bookRepository.findAllByTitleContainsIgnoreCase(title.trim())
                .stream()
                .map(this::retornaDTO)
                .toList();

        return booksDTO;
    }

    public List<BookDTO> findAllByTitleCustom(String title) {
        List<BookDTO> booksDTO = bookRepository.findAllByTitleContainsIgnoreCaseCustom(title.trim())
                .stream()
                .map(this::retornaDTO)
                .toList();

        return booksDTO;
    }

    public BookDTO create(BookCreateDTO bookCreateDTO) {
        BookEntity bookEntity = retornaEntity(bookCreateDTO);

        BookEntity bookSaved = bookRepository.save(bookEntity);

        return retornaDTO(bookSaved);
    }

    public BookDTO update(Long bookId, BookUpdateDTO bookUpdateDTO) throws Exception {
        BookEntity bookEntity = bookRepository.findById(bookId).orElseThrow(() -> new Exception("Livro não encontrado."));

        if(bookUpdateDTO.getTitle() != null) bookEntity.setTitle(bookUpdateDTO.getTitle());
        if(bookUpdateDTO.getIsbn() != null) bookEntity.setIsbn(bookUpdateDTO.getIsbn());
        if(bookUpdateDTO.getAuthor() != null) bookEntity.setAuthor(bookUpdateDTO.getAuthor());
        if(bookUpdateDTO.getPublisher() != null) bookEntity.setAuthor(bookUpdateDTO.getPublisher());
        if(bookUpdateDTO.getPrice() != null) bookEntity.setPrice(bookUpdateDTO.getPrice());

        BookEntity bookUpdatedSaved = bookRepository.save(bookEntity);

        return retornaDTO(bookUpdatedSaved);
    }

    public void delete(Long bookId) throws Exception {
        BookEntity bookEntity = bookRepository.findById(bookId).orElseThrow(() -> new Exception("Livro não encontrado."));
        bookRepository.delete(bookEntity);
    }

    private BookEntity retornaEntity(BookCreateDTO bookCreateDTO) {
        BookEntity bookEntity = new BookEntity(
                bookCreateDTO.getTitle(),
                bookCreateDTO.getAuthor(),
                bookCreateDTO.getPublisher(),
                bookCreateDTO.getIsbn(),
                bookCreateDTO.getPrice()
        );

        return bookEntity;
    }

    private BookDTO retornaDTO(BookEntity bookEntity) {
        BookDTO bookDTO = new BookDTO(
                bookEntity.getIdBook(),
                bookEntity.getTitle(),
                bookEntity.getAuthor(),
                bookEntity.getPublisher(),
                bookEntity.getIsbn(),
                bookEntity.getPrice()
        );

        return bookDTO;
    }
}
