package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;




@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;
	
	@Test
	public void createNewBook() {
    	Book book = new Book("1255323-21", "Truth Matters", "Clive Hemingway", 1959, 9.99, new Category("Romance"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
	
	
	
	  @Test
	    public void findByTitleShouldReturnBook() {
	        List<Book> books = repository.findByTitle("Harry Potter");
	        
	        assertThat(books).hasSize(1);
	        assertThat(books.get(0).getAuthor()).isEqualTo("J. K. Rowling");
	    }
	  
	  @Test
		public void deleteAllBooks() {
	    	repository.deleteAll();
	    	assertThat(repository.count()).isEqualTo(0);
	    }
	
}
