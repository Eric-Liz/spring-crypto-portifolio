package com.ericliz.cryptoportifolio;

import com.ericliz.cryptoportifolio.model.Item;
import com.ericliz.cryptoportifolio.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}
	@Bean
	CommandLineRunner initDatabase(ItemRepository itemRepository){

		return args->{
			itemRepository.deleteAll();
			for(int j=0;j<5;j++){
				Item i= new Item();
				i.setCategory("categoryTst");
				i.setName("nameTst"+j);
				i.setPrice(new BigDecimal((j+33.39)*534.27));
				i.setQuantity(new BigDecimal((j+98.33)*5.38));
				itemRepository.save(i);
			}



		};
	}
}
