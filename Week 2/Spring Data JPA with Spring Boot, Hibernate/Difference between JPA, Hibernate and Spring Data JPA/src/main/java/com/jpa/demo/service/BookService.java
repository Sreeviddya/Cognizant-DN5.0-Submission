package com.jpa.demo.service;

import com.jpa.demo.entity.Book;
import com.jpa.demo.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(String title, String author) {
        Book book = new Book(title, author);
        return bookRepository.save(book);
    }

    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
