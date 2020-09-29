package hh.swd20.betterbookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.betterbookstore.domain.Book;
import hh.swd20.betterbookstore.domain.BookRepository;
import hh.swd20.betterbookstore.domain.Category;
import hh.swd20.betterbookstore.domain.CategoryRepository;

@SpringBootApplication
public class BetterbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetterbookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			
			crepository.save(new Category("Finance"));
			crepository.save(new Category("Languages"));
			crepository.save(new Category("Mathematics"));
			
			repository.save(new Book("Immateriaalioikeuden perusteet", "Haarmann P.", 2012, "978-952-14-1786-9", 35.50, crepository.findByName("Finance").get(0)));
			repository.save(new Book("Grammatik Galleri", "Kaunisto S.", 2014, "978-951-1-20160-1", 40.75, crepository.findByName("Languages").get(0)));
			repository.save(new Book("Laskentatoimi", "Jormakka .R", 2016, "978-951-37-6622-1", 25.50, crepository.findByName("Mathematics").get(0)));
	
		};
	}

}
