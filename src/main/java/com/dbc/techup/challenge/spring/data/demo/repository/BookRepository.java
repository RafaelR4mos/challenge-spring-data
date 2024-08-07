package com.dbc.techup.challenge.spring.data.demo.repository;

import com.dbc.techup.challenge.spring.data.demo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findAllByTitleContainsIgnoreCase(String title);

    @Query("SELECT b " +
            "FROM books b " +
            "WHERE upper(b.title) LIKE upper(:title) ")
    List<BookEntity> findAllByTitleContainsIgnoreCaseCustom(String title);
}
