package guru.springframework.spring6webapp.controllers;

import org.springframework.ui.Model;

import guru.springframework.spring6webapp.services.BookService;

public class BookController {
private final BookService bookService;

public BookController(BookService bookService) {
	super();
	this.bookService = bookService;
}

public String getBooks(Model model) {
	return model.addAttribute(attributeName: "books", );
	
}
}
