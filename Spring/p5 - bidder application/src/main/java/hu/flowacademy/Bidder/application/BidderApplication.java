package hu.flowacademy.Bidder.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class BidderApplication {

	public static void main(String[] args) {

		SpringApplication.run(BidderApplication.class, args);

	}

}
