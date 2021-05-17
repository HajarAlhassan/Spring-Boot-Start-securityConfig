package com.tts.Spring.Boot.Start;

import com.tts.Spring.Boot.Start.model.Book;
import com.tts.Spring.Boot.Start.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories("com.tts.Spring.Boot.Start.repository")//optional
@EntityScan("com.tts.Spring.Boot.Start.model")// optional
@SpringBootApplication
public class SpringBootStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartApplication.class, args);

	}
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {

			repository.save(new Book("Red Queen","Mary Deelan"));
			repository.save(new Book("The Lord of the rings","Hajar"));
			repository.save(new Book("Shapes and colors","Ayaa Skef"));







		};
	}
}
