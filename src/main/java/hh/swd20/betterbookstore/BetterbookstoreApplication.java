package hh.swd20.betterbookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.betterbookstore.domain.Book;
import hh.swd20.betterbookstore.domain.BookRepository;
import hh.swd20.betterbookstore.domain.Category;
import hh.swd20.betterbookstore.domain.CategoryRepository;
import hh.swd20.betterbookstore.domain.User;
import hh.swd20.betterbookstore.domain.UserRepository;

@SpringBootApplication
public class BetterbookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BetterbookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BetterbookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			crepository.save(new Category("Finance"));
			crepository.save(new Category("Languages"));
			crepository.save(new Category("Mathematics"));
			
			repository.save(new Book("Immateriaalioikeuden perusteet", "Haarmann P.", 2012, "978-952-14-1786-9", 35.50, crepository.findByName("Finance").get(0)));
			repository.save(new Book("Grammatik Galleri", "Kaunisto S.", 2014, "978-951-1-20160-1", 40.75, crepository.findByName("Languages").get(0)));
			repository.save(new Book("Laskentatoimi", "Jormakka .R", 2016, "978-951-37-6622-1", 25.50, crepository.findByName("Mathematics").get(0)));
	
			User user1 = new User("user", "$2a$10$GH/93SFB9Nrxu1V07QyGjuCY8rrz17ZIxJ2631e7KM5hHDFVKWmwO", "USER");
			User user2 = new User("admin", "$2a$10$n0KoYGbmyAwak6CcMxluL.torTqYCcDcH3hrgOAv0b4bCQoOkVNpm", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
