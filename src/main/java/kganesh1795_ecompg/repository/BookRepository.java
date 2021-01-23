package kganesh1795_ecompg.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import kganesh1795_ecompg.model.Book;

public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
	public Page<Book> findAll(Pageable pageable);
	
	@Query("{$text: {$search: ?0}}")
	public Page<Book> findByText(String text, Pageable pageable);
}