package hu.flowacademy.Bidder.application.Domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Qbid")
public class Bid {
    public Bid(int bidPrice, String name, LocalDateTime bidTime) {
        this.bidPrice = bidPrice;
        this.name = name;
        this.bidTime = bidTime;
    }

    public Bid() {
    }

    @Id
    @SequenceGenerator(name="bidSeqGenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "bidSeqGenerator", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @Column
    private int bidPrice;
    @Column
    private String name;
    @Column
    private LocalDateTime bidTime;

    @ManyToOne
    @JoinColumn(name = "qproducts_id", foreignKey = @ForeignKey(name = "fk_qproducts_qbid"))
    private Product Qproducts;

    @Transient
    private String qproductsid;

    public Product getProducts() {
        return Qproducts;
    }

    public void setProducts(Product products) {
        this.Qproducts = products;
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

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
