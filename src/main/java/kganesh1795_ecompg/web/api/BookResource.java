package kganesh1795_ecompg.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kganesh1795_ecompg.model.Book;
import kganesh1795_ecompg.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookResource {
	@Autowired
	BookService bookService;
	
	@GetMapping
	public Iterable<Book> getBooks(@RequestParam(required=false) String text, Pageable pageable) {
		if(text == null) {
			return bookService.findAll(pageable);
		}
		else
			return bookService.findByText(text, pageable);
	}
}
