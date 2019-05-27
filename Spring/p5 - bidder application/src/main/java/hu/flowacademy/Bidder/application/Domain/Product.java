package hu.flowacademy.Bidder.application.Domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    public Product(String productName, String productDesc, int minimalPrice, Date productAddedDate, Date productTimeLeft) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.minimalPrice = minimalPrice;
        this.productAddedDate = productAddedDate;
        this.productTimeLeft = productTimeLeft;
    }

    @Id
    @SequenceGenerator(name="productSeqGenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "productSeqGenerator", strategy = GenerationType.SEQUENCE)
    @Column
    private long id;

    @OneToMany(mappedBy = "products")
    private List<Bid> bid;

    @Column
    private String productName;

    @Column
    private String productDesc;

    @Column
    private int minimalPrice;

    @Column
    private Date productAddedDate;

    @Column
    private Date productTimeLeft;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getMinimalPrice() {
        return minimalPrice;
    }

    public void setMinimalPrice(int minimalPrice) {
        this.minimalPrice = minimalPrice;
    }

    public Date getProductAddedDate() {
        return productAddedDate;
    }

    public void setProductAddedDate(Date productAddedDate) {
        this.productAddedDate = productAddedDate;
    }

    public Date getProductTimeLeft() {
        return productTimeLeft;
    }

    public void setProductTimeLeft(Date productTimeLeft) {
        this.productTimeLeft = productTimeLeft;
    }

    public long getId() {
        return id;
    }

    public List<Bid> getBids() {
        return bid;
    }

    public void setBids(List<Bid> bids) {
        this.bid = bid;
    }
}
