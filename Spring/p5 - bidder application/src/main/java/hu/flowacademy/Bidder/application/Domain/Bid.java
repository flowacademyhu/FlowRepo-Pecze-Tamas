package hu.flowacademy.Bidder.application.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "bid")
public class Bid {
    public Bid(int bidPrice, String name, LocalDate bidTime) {
        this.bidprice = bidPrice;
        this.name = name;
        this.bidtime = bidTime;
    }
    public Bid(int bidPrice, String name) {
        this.bidprice = bidPrice;
        this.name = name;
        this.bidtime = bidtime;
    }
    public Bid() {
    }

    @Id
    @SequenceGenerator(name="bidSeqGenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "bidSeqGenerator", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @Column
    private int bidprice;
    @Column
    private String name;
    @Column
    private LocalDate bidtime;

    @ManyToOne
    @JoinColumn(name = "products_id", foreignKey = @ForeignKey(name = "fk_products_bid"))
    private Product products;

    public int getBidprice() {
        return bidprice;
    }

    public void setBidprice(int bidprice) {
        this.bidprice = bidprice;
    }

    public LocalDate getBidtime() {
        return bidtime;
    }

    public void setBidtime(LocalDate bidtime) {
        this.bidtime = bidtime;
    }


    public int getBidPrice() {
        return bidprice;
    }

    public void setBidPrice(int bidPrice) {
        this.bidprice = bidPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBidTime() {
        return bidtime;
    }

    public void setBidTime(LocalDate bidTime) {
        this.bidtime = bidTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product qproducts) {
        products = qproducts;
    }
}
