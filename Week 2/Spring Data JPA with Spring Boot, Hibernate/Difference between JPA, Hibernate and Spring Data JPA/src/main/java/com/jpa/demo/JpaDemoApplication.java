package com.jpa.demo;

import com.jpa.demo.entity.Book;
import com.jpa.demo.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class JpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(BookService bookService) {
        return args -> {
            System.out.println("\n=== Saving books using Spring Data JPA ===");
            bookService.createBook("The Great Gatsby", "F. Scott Fitzgerald");
            bookService.createBook("1984", "George Orwell");
            bookService.createBook("Animal Farm", "George Orwell");

            System.out.println("\n=== Finding books by author (George Orwell) ===");
            List<Book> orwellBooks = bookService.findBooksByAuthor("George Orwell");
            orwellBooks.forEach(System.out::println);

            System.out.println("\n=== All books ===");
            bookService.getAllBooks().forEach(System.out::println);
        };
    }
}
