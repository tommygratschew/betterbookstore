package hh.swd20.betterbookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.betterbookstore.domain.Book;
import hh.swd20.betterbookstore.domain.BookRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTest {

	@Autowired
	private BookRepository bRepository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = bRepository.findByTitle("Immateriaalioikeuden perusteet");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Haarmann P.");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("asd", "asd", 2020, "asd", 12.34, null);
		bRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}

}
