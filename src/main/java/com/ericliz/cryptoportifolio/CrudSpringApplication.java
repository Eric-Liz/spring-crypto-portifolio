package com.ericliz.cryptoportifolio;

import com.ericliz.cryptoportifolio.model.Item;
import com.ericliz.cryptoportifolio.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}
	@Bean
	CommandLineRunner initDatabase(ItemRepository itemRepository){

		return args->{
			itemRepository.deleteAll();
			Item i= new Item();
			i.setCategory("categoryTst");
			i.setName("nameTst");
			itemRepository.save(i);
		};
	}
}
