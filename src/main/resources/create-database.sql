CREATE TABLE BOOKS (
    id_book NUMBER NOT NULL,
    title VARCHAR2(200) NOT NULL,
    author VARCHAR2(200) NOT NULL,
    publisher VARCHAR2(200) NOT NULL,
    isbn VARCHAR2(20) NOT NULL UNIQUE,
    price NUMBER(6,2) NOT NULL,
    PRIMARY KEY(id_book)
);

CREATE SEQUENCE seq_book_db
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

INSERT INTO BOOKS (id_book, title, author, publisher, isbn, price) VALUES
(seq_book_db.NEXTVAL, 'The Catcher in the Rye', 'J.D. Salinger', 'Little, Brown and Company', '9780316769488', 10.99);

INSERT INTO BOOKS (id_book, title, author, publisher, isbn, price) VALUES
(seq_book_db.NEXTVAL, 'To Kill a Mockingbird', 'Harper Lee', 'J.B. Lippincott & Co.', '9780061120084', 7.99);

INSERT INTO BOOKS (id_book, title, author, publisher, isbn, price) VALUES
(seq_book_db.NEXTVAL, '1984', 'George Orwell', 'Secker & Warburg', '9780451524935', 8.99);

INSERT INTO BOOKS (id_book, title, author, publisher, isbn, price) VALUES
(seq_book_db.NEXTVAL, 'Pride and Prejudice', 'Jane Austen', 'T. Egerton', '9781503290563', 9.99);

INSERT INTO BOOKS (id_book, title, author, publisher, isbn, price) VALUES
(seq_book_db.NEXTVAL, 'The Great Gatsby', 'F. Scott Fitzgerald', 'Charles Scribners Sons', '9780743273565', 10.99);