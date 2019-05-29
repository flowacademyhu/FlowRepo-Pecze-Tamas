package hu.flowacademy.Bidder.application.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Qproducts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
    public Product(String productName, String productDesc, int minimalPrice, Date productAddedDate, Date productTimeLeft) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.minimalPrice = minimalPrice;
        this.productAddedDate = productAddedDate;
        this.productTimeLeft = productTimeLeft;
    }
    public Product(String productName, String productDesc, int minimalPrice, Date productAddedDate, Date productTimeLeft, List bid) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.minimalPrice = minimalPrice;
        this.productAddedDate = productAddedDate;
        this.productTimeLeft = productTimeLeft;
        this.Qbid = bid;
    }
    public Product() {
    }

    @Id
    @SequenceGenerator(name="productsSeqGenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "productsSeqGenerator", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @OneToMany(mappedBy = "Qproducts")
    private List<Bid> Qbid;

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
        return Qbid;
    }

    public void setBids(List<Bid> bids) {
        this.Qbid = Qbid;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Bid> getBid() {
        return Qbid;
    }

    public void setBid(List<Bid> qbid) {
        this.Qbid = qbid;
    }

    public List<Bid> getQbid() {
        return Qbid;
    }

    public void setQbid(List<Bid> qbid) {
        Qbid = qbid;
    }
}
