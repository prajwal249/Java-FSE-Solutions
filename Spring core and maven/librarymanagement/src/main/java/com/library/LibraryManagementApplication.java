package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;
import com.library.repository.BookRepository;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml")) {

            BookService service = context.getBean("bookService", BookService.class);
            BookRepository repository = context.getBean("bookRepository", BookRepository.class);

            service.displayService();
            repository.displayRepository();
        }
    }
}