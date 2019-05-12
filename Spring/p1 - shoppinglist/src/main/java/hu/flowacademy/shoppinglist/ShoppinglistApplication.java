package hu.flowacademy.shoppinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ShoppinglistApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppinglistApplication.class, args);
	}

}
