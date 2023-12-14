package com.jot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {

	@Autowired
	BookRepository bookRepo;
	
	@Test
	void testInsertDeleteGet() {
		
		bookRepo.insert(new Book(1,"Lord Of the Rings", "J.R.R. Tolkien"));
		
		Book result = bookRepo.findById(1).get();
		
		Assertions.assertEquals("Lord Of the Rings", result.name());
		
		bookRepo.deleteById(1);
		
		result = bookRepo.findById(1).get();
		
		Assertions.assertNull(result);
			
	}

}
