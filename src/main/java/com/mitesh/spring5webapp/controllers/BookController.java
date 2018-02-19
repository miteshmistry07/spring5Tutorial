package com.mitesh.spring5webapp.controllers;

import com.mitesh.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //manage class as spring bean
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") //controller method
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll()); //add attribute books
        return "books";
    }
}
