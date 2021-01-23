package kganesh1795_ecompg.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kganesh1795_ecompg.model.Book;

public interface CustomBookService {
	public Page<Book> findAll(Pageable pageable);
	public Page<Book> findByText(String text, Pageable pageable);
}
