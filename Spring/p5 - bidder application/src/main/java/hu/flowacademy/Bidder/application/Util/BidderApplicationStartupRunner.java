package hu.flowacademy.Bidder.application.Util;

import hu.flowacademy.Bidder.application.Domain.Bid;
import hu.flowacademy.Bidder.application.Domain.Product;
import hu.flowacademy.Bidder.application.Repository.BidRepository;
import hu.flowacademy.Bidder.application.Repository.ProductRepostiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class BidderApplicationStartupRunner implements CommandLineRunner {

    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private ProductRepostiry productRepostiry;

    LocalDate actualDateTime1 = LocalDate
            .of(2018, Month.JUNE,03);
    LocalDate actualDateTime2 = LocalDate
            .of(2018, Month.JUNE, 25 );
    LocalDate actualDateTime3 = LocalDate
            .of(2018, Month.JUNE, 25);
    @Override
    public void run(String... args) throws Exception {
        Bid bid1 = new Bid(500, "Pali",actualDateTime1);
        Bid bid2 = new Bid(1500, "Jozsi",actualDateTime2);
        Bid bid3 = new Bid(2500, "Pali",actualDateTime3);
        Product product1 = new Product("Hasznalt legycsapo",
                "Alig hasznalt, csak 2 legyet es egy tengeri sullot utottem le vele",
                1,new Date(13/06/2018),new Date());
        productRepostiry.save(product1);
        bidRepository.save(bid1);
        bidRepository.save(bid2);
        bidRepository.save(bid3);
    }


}
