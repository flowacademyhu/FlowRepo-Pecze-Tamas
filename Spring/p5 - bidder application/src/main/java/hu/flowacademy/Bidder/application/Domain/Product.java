package hu.flowacademy.Bidder.application.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Qproducts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
    public Product( String productname, String productdesc, int minimalprice, Date productaddeddate, Date producttimeleft) {

        this.productname = productname;
        this.productdesc = productdesc;
        this.minimalprice = minimalprice;
        this.productaddeddate = productaddeddate;
        this.producttimeleft = producttimeleft;
    }

    public Product() {
    }

    @Id
    @SequenceGenerator(name="productsSeqGenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "productsSeqGenerator", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @JsonIgnore
    @OneToMany(mappedBy = "products")
    private List<Bid> bid;

    @Column
    private String productname;

    @Column
    private String productdesc;

    @Column
    private int minimalprice;

    @Column
    private Date productaddeddate;

    @Column
    private Date producttimeleft;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Bid> getBid() {
        return bid;
    }

    public void setBid(List<Bid> bid) {
        this.bid = bid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public int getMinimalprice() {
        return minimalprice;
    }

    public void setMinimalprice(int minimalprice) {
        this.minimalprice = minimalprice;
    }

    public Date getProductaddeddate() {
        return productaddeddate;
    }

    public void setProductaddeddate(Date productaddeddate) {
        this.productaddeddate = productaddeddate;
    }

    public Date getProducttimeleft() {
        return producttimeleft;
    }

    public void setProducttimeleft(Date producttimeleft) {
        this.producttimeleft = producttimeleft;
    }
}
