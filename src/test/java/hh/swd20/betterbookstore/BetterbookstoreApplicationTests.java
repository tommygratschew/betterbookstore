package hh.swd20.betterbookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.betterbookstore.web.BookController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BetterbookstoreApplicationTests {
	
	@Autowired
	private BookController bookController;

	@Test
	void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
	}
	
}
