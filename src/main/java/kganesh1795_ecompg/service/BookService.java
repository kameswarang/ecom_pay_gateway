package kganesh1795_ecompg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kganesh1795_ecompg.model.Book;
import kganesh1795_ecompg.repository.BookRepository;
import kganesh1795_ecompg.service.interfaces.CustomBookService;

@Service
public class BookService implements CustomBookService {
	private BookRepository br;
	@Autowired
	public BookService(BookRepository br) {
		this.br = br;
	}
	
	public Page<Book> findAll(Pageable pageable) {
		return br.findAll(pageable);
	}
	
	public Page<Book> findByText(String text, Pageable pageable) {
		return br.findByText(text, pageable);
	}
}
