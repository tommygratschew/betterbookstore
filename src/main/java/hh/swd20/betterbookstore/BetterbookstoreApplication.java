package hh.swd20.betterbookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.betterbookstore.domain.Book;
import hh.swd20.betterbookstore.domain.BookRepository;

@SpringBootApplication
public class BetterbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetterbookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Immateriaalioikeuden perusteet", "Haarmann P.", 2012, "978-952-14-1786-9", 35.50);
			Book b2 = new Book("Grammatik Galleri", "Kaunisto S.", 2014, "978-951-1-20160-1", 40.75);
			Book b3 = new Book("Laskentatoimi", "Jormakka .R", 2016, "978-951-37-6622-1", 25.50);
			
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}

}
