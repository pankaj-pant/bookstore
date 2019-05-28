package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;





@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {

		return (args) -> {
			log.info("save a couple of books");
		
			
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Non-Fiction"));
			crepository.save(new Category("Sci-Fi"));
			
			

			Book book1 = new Book("1232323-21", "A Farewell to Arms", "Ernst Hemingway", 1929, 12.99, crepository.findByName("Fiction").get(0));
			Book book2 = new Book("12323233-33", "Harry Potter", "J. K. Rowling", 1995, 12.99, crepository.findByName("Fiction").get(0));
			Book book3 = new Book("1232344-44", "Lord of the Rings", "J. R. R. Tolkien", 1929, 12.99, crepository.findByName("Fiction").get(0));

			repository.save(book1);
			repository.save(book2);
			repository.save(book3);
			
			// Create users: admin/admin user/user
						User user1 = new User("user", "$2a$10$uUCQxVK.F7dKeKPaZyI01evxZTWvDdXUdzqI0U9G3iUWIwjVw423y", "user@bookstore.com", "USER");
						User user2 = new User("admin", "$2a$10$oGZS6HF.o5DnH/1gekJ11.cZm0iu9./AosezueO3IQ0Qs66wDW1xe", "admin@bookstore.com", "ADMIN");
						urepository.save(user1);
						urepository.save(user2);

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
	

		};
	}

}
