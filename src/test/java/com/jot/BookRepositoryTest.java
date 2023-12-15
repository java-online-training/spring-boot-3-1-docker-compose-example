package com.jot;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepo;

	@BeforeEach
	public void clean() {
		bookRepo.deleteAll();
	}

	@Test
	void testInsertDeleteGet() {

		bookRepo.insert(new Book(1, "Lord Of the Rings", "J.R.R. Tolkien"));

		Book result = bookRepo.findById(1).get();

		Assertions.assertEquals("Lord Of the Rings", result.name());

		bookRepo.deleteById(1);

		Optional<Book> result2 = bookRepo.findById(1);

		Assertions.assertNull(result2.orElse(null));

	}
}
