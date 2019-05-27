package hu.flowacademy.Bidder.application.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bids")
public class Bid {
    public Bid(int bidPrice, String name, Date bidTime) {
        this.bidPrice = bidPrice;
        this.name = name;
        this.bidTime = bidTime;
    }

    @Id
    @SequenceGenerator(name="bidSeqGenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "bidSeqGenerator", strategy = GenerationType.SEQUENCE)
    @Column
    private long id;
    @Column
    private int bidPrice;
    @Column
    private String name;
    @Column
    private Date bidTime;
    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_products_bid"))
    private Product products;

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBidTime() {
        return bidTime;
    }

    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }

    public long getId() {
        return id;
    }
}
