package kganesh1795_ecompg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="books")
public class Book {
	@Id
	private int id;
	private String title;
	private String authors;
	private double averageRating;
	private long isbn;
	private String languageCode;
	private long ratingsCount;
	private long price;
}
